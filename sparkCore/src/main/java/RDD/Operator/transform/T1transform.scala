package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T1transform {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4))
        // map
        val mapRDD = rdd.map(_ * 2)

        mapRDD.collect().foreach(println)

        sc.stop()
    }

}
