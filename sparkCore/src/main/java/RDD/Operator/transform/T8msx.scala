package RDD.Operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object T8msx {
    def main(args: Array[String]): Unit = {
        val msx = new SparkConf().setMaster("local").setAppName("msx")
        val context = new SparkContext(msx)


        context.stop()
    }

}
