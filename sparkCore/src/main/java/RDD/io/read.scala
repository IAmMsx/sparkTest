package RDD.io

import org.apache.spark.{SparkConf, SparkContext}

object read {
    def main(args: Array[String]): Unit = {
        val sparConf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
        val sc = new SparkContext(sparConf)
        val rdd1 = sc.textFile("output1")
        rdd1.collect().foreach(println)
        val rdd2 = sc.objectFile[(String,Int)]("output2")
        rdd2.collect().foreach(println)
        val rdd3 = sc.sequenceFile[String,Int]("output3")
        rdd3.collect().foreach(println)
        sc.stop()
    }
}
