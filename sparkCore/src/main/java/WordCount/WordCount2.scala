package WordCount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount2 {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("wordCount2")
        val sc = new SparkContext(sparkConf)

        val lines: RDD[String] = sc.textFile("data/*")

        val wordTuple: RDD[(String, Int)] = lines.flatMap((_: String).split(" ").map((_: String, 1)))

        val wordGroup: RDD[(String, Iterable[(String, Int)])] = wordTuple.groupBy((_: (String, Int))._1)

        val wordToCount: RDD[(String, Int)] = wordGroup.map({
            case (_, itor) =>
                itor.reduce(
                    (t1, t2) => {
                        (t1._1, t1._2 + t2._2)
                    }
                )
        }
        )
        val array: Array[(String, Int)] = wordToCount.collect()
        array.foreach(println)

        sc.stop()

    }

}
