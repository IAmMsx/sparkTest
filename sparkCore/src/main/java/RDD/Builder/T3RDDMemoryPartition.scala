package RDD.Builder

import org.apache.spark.{SparkConf, SparkContext}

object T3RDDMemoryPartition {
    def main(args: Array[String]): Unit ={
        // 环境准备
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)
        // 创建RDD
        // RDD 并行度和分区
        // makeRDD方法可以传递第二个参数，这个参数表示分区数量
        val rdd = sc.makeRDD(
            List(1, 2, 3, 4), 2
        )
        rdd.saveAsTextFile("output")

        // 关闭环境
        sc.stop()
    }

}
