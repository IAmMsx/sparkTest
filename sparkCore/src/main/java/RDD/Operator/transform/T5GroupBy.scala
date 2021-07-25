package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T5GroupBy {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        //            val rdd = sc.makeRDD(List(1, 2, 3, 4), 2)
        //            // groupBy将数据原中的每一个数据进行分组判断，根据返回的分组key进行分组
        //            // 相同的key值的数据将会放置在一个组中
        //            val groupRDD = rdd.groupBy(_ % 2)
        //            groupRDD.collect().foreach(println)

        val rdd = sc.makeRDD(List("Hello", "Spark", "Scala","msx"), 2)
        val groupRDD = rdd.groupBy(_.charAt(0))
        groupRDD.collect().foreach(println)


        sc.stop()
    }
}
