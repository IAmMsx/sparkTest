package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T7Sample {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

        // sample 算子需要传递三个参数
        // 第一个参数表示 抽取数据后是否返回true放回 false 不放回
        // 第二个参数表示
        //          如果抽取不放回，表示数据源中每条数据被抽取的概率
        //          如果抽取放回，表示数据源中每条数据被抽取的可能次数
        // 第三个参数表示 抽取数据时随机算法的种子
        println(rdd.sample(
            withReplacement = true,
            2,
            8848
        ).collect().mkString(","))
        sc.stop()
    }

}
