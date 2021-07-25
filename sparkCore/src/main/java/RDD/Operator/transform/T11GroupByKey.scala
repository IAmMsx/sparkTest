package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T11GroupByKey {
    def main(args: Array[String]): Unit = {
        val SparkConf = new SparkConf().setMaster("local").setAppName("msx")
        val sc = new SparkContext(SparkConf)

        val rdd = sc.makeRDD(List(("a", 1), ("b", 2), ("a", 1), ("b", 3)))
        // 相同key的数据分在一个组中，形成一个对偶元组
        // 元组中第一个元素就是key
        // 第二个元素是相同key的value的集合
        rdd.groupByKey().collect().foreach(println)

        sc.stop()
    }

}
