package RDD.Builder

import org.apache.spark.{SparkConf, SparkContext}

object T1RDDMemory {
    def main(args: Array[String]): Unit = {
        // 准备环境
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)
        // 创建环境
        // 从内存中创建RDD，将内存中集合的数据作为处理的数据源
        val seq = Seq[Int](1, 2, 3, 4)
//        val rdd = sc.parallelize(seq)

        val value = sc.makeRDD(seq)
        value.collect().foreach(print)
        // 关闭环境
        sc.stop()
    }
}
