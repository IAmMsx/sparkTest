package RDD.Operator.action

import org.apache.spark.{SparkConf, SparkContext}

object T1actionSummarize {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4))
        // 行动算子就是触发作业执行的方法
        rdd.collect()

        sc.stop()
    }

}