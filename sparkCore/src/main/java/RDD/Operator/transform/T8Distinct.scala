package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}
// 去重
object T8Distinct {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4, 1, 2))
        rdd.distinct().collect().foreach(println)

        sc.stop()
    }

}
