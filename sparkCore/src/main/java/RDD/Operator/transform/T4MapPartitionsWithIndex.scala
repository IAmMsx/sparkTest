package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T4MapPartitionsWithIndex {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4),2)
        // [1,2] [3,4]

        // (index,itor) => itor
        val mapPWIRDD = rdd.mapPartitionsWithIndex(
            (index, itor) => {
                if (index == 0) {
                    itor
                } else {
                    Nil.iterator
                }
            }
        )
        mapPWIRDD.collect().foreach(println)
        sc.stop()

    }

}
