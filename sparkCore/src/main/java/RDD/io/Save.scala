package RDD.io

import org.apache.spark.{SparkConf, SparkContext}

object Save {
    def main(args: Array[String]): Unit = {
        val sparConf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
        val sc = new SparkContext(sparConf)
        val rdd = sc.makeRDD(List(("a", 1), ("b", 2), ("a", 1), ("b", 3)))
        rdd.saveAsTextFile("output1")
        rdd.saveAsObjectFile("output2")
        rdd.saveAsSequenceFile("output3")
        sc.stop()
    }

}
