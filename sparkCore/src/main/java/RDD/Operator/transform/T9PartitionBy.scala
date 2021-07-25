package RDD.Operator.transform

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

class msxPartitioner(partitions: Int) extends Partitioner {
    override def numPartitions: Int = partitions

    override def getPartition(key: Any): Int = key match {
        case null => 0
        case key if key == 1 || key == 4 => 0
        case key if key == 2 || key == 3 => 1
    }
}

object T9PartitionBy {
    def main(args: Array[String]): Unit = {
        val SparkConf = new SparkConf().setMaster("local").setAppName("msx")
        val sc = new SparkContext(SparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4), 2)
        val mapRDD = rdd.map((_, 1))

        mapRDD.partitionBy(new msxPartitioner(2))
          .saveAsTextFile("output")
        sc.stop()

    }

}
