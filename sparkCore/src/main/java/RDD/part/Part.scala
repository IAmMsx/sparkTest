package RDD.part

import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

object Part {
    def main(args: Array[String]): Unit = {
        val sparConf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
        val sc = new SparkContext(sparConf)

        val rdd = sc.makeRDD(List(
            ("nba", "xxxxxxxxxxxxxxx"),
            ("cba", "xxxxxxxxxxxxxxx"),
            ("wnba", "xxxxxxxxxxxxxxx"),
            ("nba", "xxxxxxxxxxxxxxx"),
            ("nba", "xxxxxxxxxxxxxxx"),
        ),3)

        val partitionRDD = rdd.partitionBy(new MyPartitioner)
        partitionRDD.saveAsTextFile("output")

        sc.stop()
    }

    /*
        自定义分区器
     */
    class MyPartitioner extends Partitioner {
        override def numPartitions: Int = 3

        // 根据数据的key值返回分区索引 从0开始
        override def getPartition(key: Any): Int = {
            key match {
                case "nba" => 0
                case "cba" => 1
                case _ => 2
            }
        }
    }

}
