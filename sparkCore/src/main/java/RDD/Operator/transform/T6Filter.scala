package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T6Filter {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.textFile("data/apache.log")
        rdd.filter(
            line => {
                val datas = line.split(" ")(3)
                datas.startsWith("17/05/2015")
        }).collect().foreach(println)

        sc.stop()
    }
}
