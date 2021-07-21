package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T4MPTest {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        //        val rdd = sc.makeRDD(List(1, 2, 3, 4),2)

        //        // 取每个分区的最大值
        //        // itor => itor
        //        val mapRDD = rdd.mapPartitions(
        //            iter => {
        //                List(iter.max).iterator
        //            }
        //        )

        // 获取数据在哪个分区中
        val rdd = sc.makeRDD(List(1, 2, 3, 4))
        val mapRDD = rdd.mapPartitionsWithIndex(
            (index, itor) => {
                itor.map((index, _))
            }
        )

        mapRDD.collect().foreach(println)

        sc.stop()

    }
}
