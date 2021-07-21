package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T3Partition {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        // 同一分区内数据是一个一个的执行逻辑hi
        // 前一个数据逻辑执行完毕后，再执行下一个数据
        // 因此 分区内数据执行有序
        // 不同分区内数据无序
        val rdd = sc.makeRDD(List(1, 2, 3, 4),2)
        val mapRDD = rdd.map(
            num => {
                println(">>>>>>>>>>>>>>>" + num)
                num
            }
        )
        val mapRDD1 = mapRDD.map(
            num => {
                println("##############" + num)
                num
            }
        )
        mapRDD1.collect()

        sc.stop()
    }

}
