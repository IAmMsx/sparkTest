package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T13join {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd1 = sc.makeRDD(List(("a", 1), ("a", 2), ("c", 3)))
        val rdd2 = sc.makeRDD(List(("a", 4), ("a", 5), ("c", 6)))

        // join 不同数据源的数据，相同key的value会连接在一起，形成元组
        //      如果两个数据源中的key没有匹配上，则数据不会出现在结果中
        //      key如果有相同的，依次匹配，(key,(v1,v2)) 数据量会几何增长，可能性能降低
        val joinRDD = rdd1.join(rdd2)
        joinRDD.collect.foreach(println)

        sc.stop()

    }

}
