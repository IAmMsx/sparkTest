package req

import org.apache.spark.{SparkConf, SparkContext}

object T3NewHotCategoryTop10Analysis {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
        val sc = new SparkContext(sparkConf)
        // 点击转换成（id,(1,0,0)）
        // 下单转换成（id,(0,1,0)）
        // 支付转换成（id,(0,0,1)）
        val actionRDD = sc.textFile("data/user_visit_action.txt")
        val value = actionRDD.flatMap(
            action => {
                val datas = action.split("_")
                if (datas(6) != "-1") {
                    // 点击
                    List((datas(6), (1, 0, 0)))
                } else if (datas(8) != "null") {
                    // 下单
                    val ids = datas(8).split(",")
                    ids.map(id => (id, (0, 1, 0)))
                } else if (datas(10) != "null") {
                    val ids = datas(10).split(",")
                    ids.map(id => (id, (0, 0, 1)))
                } else {
                    Nil
                }
            }
        )
        val analysRDD = value.reduceByKey(
            (t1, t2) => {
                (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
            }
        )


        val resultRDD = analysRDD.sortBy(_._2, ascending = false).take(10)
        // 6. 将结果采集到控制台并打印
        resultRDD.foreach(println)
        sc.stop()
    }

}
