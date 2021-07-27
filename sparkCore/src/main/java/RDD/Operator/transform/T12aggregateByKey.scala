package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T12aggregateByKey {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        // 实现分区内排序，分区间最大值求和
        val rdd = sc.makeRDD(List(("a", 1), ("a", 2),("a",5), ("a", 2), ("a", 3),("a",4)), 2)
        val tuple = rdd.mapPartitions(itor => itor.toSeq.sortWith(_._2 > _._2).take(1).toIterator)
          .reduce((list1, list2) => (list1._1, list1._2 + list2._2))
        println(tuple._2)


        // 存在函数柯里化
        // 第一个参数列表 传递一个参数 表示初始值
        //             主要用于当碰见第一个key的时候，和value进行分区计算
        // 第二个参数列表：需要传递两个参数
        //              第一个参数表示分区内计算规则
        //              第二个参数表示分区间计算规则
        rdd.aggregateByKey(0)(
            math.max,
            _ + _
        ).collect.foreach(println)

        val testRDD = sc.makeRDD(List(("a", 1), ("b", 2), ("b", 5), ("a", 2), ("a", 3), ("b", 4)), 2)
//        testRDD.aggregateByKey((0,0)){
//
//        }

        // 获取相同key的数据的平均值


        sc.stop()
    }
}
