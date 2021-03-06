package req

import org.apache.spark.{SparkConf, SparkContext}

object HotCategoryTop10Analysis {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
        val sc = new SparkContext(sparkConf)
        // TOP10热门品类

        // 1. 读取原始日志数据
        val actionRDD = sc.textFile("data/user_visit_action.txt")
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
        // 5. 排序 取前十名 (ID,(点击数量，下单数量，支付数量))
        //    点击数量 下单数量，支付数量
        //    元组排序，先比较第一个，再比较第二个，再比较第三个。
        val coGroupRDD = clickCountRDD.cogroup(orderCountRDD, payCountRDD)
        val analysRDD = coGroupRDD.mapValues {
            case (clickIter, orderIter, payIter) =>
                var clickCnt = 0
                if (clickIter.iterator.hasNext)
                    clickCnt = clickIter.iterator.next()
                var orderCnt = 0
                if (orderIter.iterator.hasNext)
                    orderCnt = orderIter.iterator.next()
                var payCnt = 0
                if (payIter.iterator.hasNext)
                    payCnt = payIter.iterator.next()
                (clickCnt,orderCnt,payCnt)
        }
        val resultRDD = analysRDD.sortBy(_._2, ascending = false).take(10)
        // 6. 将结果采集到控制台并打印
        resultRDD.foreach(println)
        sc.stop()
    }

}
