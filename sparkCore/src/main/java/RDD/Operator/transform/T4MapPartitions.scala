package RDD.Operator.transform
/*
map 与 mapParitions的区别：
1. map是对每一个元素进行操作，不能增加或者减少数据
   mapParitions算子需要传递一个迭代器，返回一个迭代器，对元素个数没有要求
2. map性能较低
   mapPartitions性能高但是可能会导致内存不够用，出现溢出的情况
 */
import org.apache.spark.{SparkConf, SparkContext}

object T4MapPartitions {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4),2)

        // mapPartitions 支持以分区为单位进行数据转换操作
        //               但是将整个分区数据加载到内存中进行引用，容易内存溢出
        val mapRDD = rdd.mapPartitions(
            iter => {
                println("<<<<<<<<<<<<<<<<<<<")
                iter.map(_ * 2)
            }
        )

        mapRDD.collect().foreach(println)
        sc.stop()

    }

}
