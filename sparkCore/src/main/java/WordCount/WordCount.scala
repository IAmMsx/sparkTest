package WordCount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
    def main(args: Array[String]): Unit = {
        // spark 框架

        // 建立和spark框架的链接
        val sparConf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
        val sc = new SparkContext(sparConf)

        // 执行业务操作

        // 1.读取文件,获取一行一行的数据
        val lines: RDD[String] = sc.textFile("data/*")
        // 2.分词
        val words: RDD[String] = lines.flatMap((_: String).split(" "))
        // 3.将数据单词分组
        val wordGroup: RDD[(String, Iterable[String])] = words.groupBy((word: String) => word)
        // 4.分组后的数据进行转换（name,count）
        val wordToCount: RDD[(String, Int)] = wordGroup.map {
            case (word, list) =>
                (word, list.size)
        }
        val array: Array[(String, Int)] = wordToCount.collect()
        array.foreach(println)
        // 关闭连接
        sc.stop()
    }

}
