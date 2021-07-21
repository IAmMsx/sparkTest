package RDD.Builder

import org.apache.spark.{SparkConf, SparkContext}

object T2RDDFile {
    def main(args: Array[String]): Unit = {
        // 准备环境
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)
        // 创建环境
        // 从文件中创建RDD，
        // path可以是具体路径，也可以是目录名称
        // 输入目录名称 读取下面的所有文件
//        val rdd = sc.textFile("data/1.txt")
//        val rdd = sc.textFile("data/*")
        // 可以是分布式存储系统路径：HDFS

        // wholeTextFiles 读取结果为元组，第一个元素为文件路径，第二个元素为文件内容
        val rdd = sc.wholeTextFiles("data/*")
        rdd.collect().foreach(println)

        // 关闭环境
        sc.stop()
    }
}
