package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T2transformTest {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val value = sc.textFile("data/apache.log")

        // 取用户URL信息
        val mapRDD = value.map(
            line => {
                line.split(" ").last
            }
        )

        mapRDD.collect().foreach(println)

        sc.stop()
    }

}
