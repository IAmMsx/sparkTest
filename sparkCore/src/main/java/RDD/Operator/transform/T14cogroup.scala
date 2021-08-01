package RDD.Operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T14cogroup {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd1 = sc.makeRDD(List(("a", 1), ("a", 2), ("c", 3)))
        val rdd2 = sc.makeRDD(List(("a", 4), ("a", 5), ("c", 6)))

        val coRDD: RDD[(String, (Iterable[Int], Iterable[Int]))] = rdd1.cogroup(rdd2)
        coRDD.map(s=>{
            (s._2._1.sum,s._2._2.sum)
        }).collect.foreach(println)


        sc.stop()
    }



}
