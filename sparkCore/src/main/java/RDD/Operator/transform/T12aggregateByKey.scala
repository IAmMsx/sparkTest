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


        sc.stop()
    }
}
