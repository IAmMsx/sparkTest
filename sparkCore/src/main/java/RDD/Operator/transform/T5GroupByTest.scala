package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T5GroupByTest {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.textFile("data/apache.log")
        val timeRDD = rdd.map(
            s => {
                val datas = s.split(" ")(3)
                val hour = datas.split(":")(1)
                (hour, 1)
            }
        ).groupBy(_._1)

        timeRDD.mapValues(_.size)
          .collect()
          .foreach(println)


        sc.stop()
    }
}