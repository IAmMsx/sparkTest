package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T10ReduceByKey {
    def main(args: Array[String]): Unit = {
        val SparkConf = new SparkConf().setMaster("local").setAppName("msx")
        val sc = new SparkContext(SparkConf)

        val rdd = sc.makeRDD(List(("a", 1), ("b", 2), ("a", 1), ("b", 3)))
        // 两两聚合 对相同key的value进行操作
        rdd.reduceByKey(
            (a, b) => a + b
        ).collect().foreach(println)

        sc.stop()
    }

}
