package req

import org.apache.spark.{SparkConf, SparkContext}

object NewHotCategoryTop10Analysis {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
        val sc = new SparkContext(sparkConf)
        // Q actionRDD重用次数较多
        // Q cogroup 存在shuffle 性能较差
        // (ID,(点击数量，0，0))
        // (ID,(0，下单数量，0))
        // (ID,(0，0，支付数量))


        // TOP10热门品类

        // 1. 读取原始日志数据
        val actionRDD = sc.textFile("data/user_visit_action.txt")
        actionRDD.cache()
        // 2. 统计品类的点击数量（品类ID,点击数量）
        val clickActionRDD = actionRDD.filter(
            action => {
                val data = action.split("_")
                data(6) != "-1"
            }
        )
        val clickCountRDD = clickActionRDD.map(
            action => {
                val data = action.split("_")
                (data(6), 1)
            }
        ).reduceByKey(_ + _)
          .mapValues((_, 0, 0))
        // 3. 统计品类的下单数量（品类ID,下单数量）
        val orderActionRDD = actionRDD.filter(
            action => {
                val data = action.split("_")
                data(8) != "null"
            }
        )
        // orderID => 1,2,3 需要flatmap [1,2,3]
        val orderCountRDD = orderActionRDD.flatMap(
            action => {
                val data = action.split("_")
                val cids = data(8).split(",")
                cids.map((_, 1))
            }
        ).reduceByKey(_ + _)
          .mapValues((0, _, 0))

        // 4. 统计品类的支付数量（品类ID,支付数量）
        val payActionRDD = actionRDD.filter(
            action => {
                val data = action.split("_")
                data(10) != "null"
            }
        )
        val payCountRDD = orderActionRDD.flatMap(
            action => {
                val data = action.split("_")
                val cids = data(10).split(",")
                cids.map((_, 1))
            }
        ).reduceByKey(_ + _)
          .mapValues((0, 0, _))
        // 5. 排序 取前十名 (ID,(点击数量，下单数量，支付数量))
        //    点击数量 下单数量，支付数量
        //    元组排序，先比较第一个，再比较第二个，再比较第三个。
        val sourceRDD = clickCountRDD.union(orderCountRDD).union(payCountRDD)
        val analysRDD = sourceRDD.reduceByKey(
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
