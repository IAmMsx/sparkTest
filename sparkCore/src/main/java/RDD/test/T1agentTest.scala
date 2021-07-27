package RDD.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T1agentTest {
    def main(args: Array[String]): Unit ={
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("test")
        val sc = new SparkContext(sparkConf)

        // 1.获取数据 时间 省份 城市 用户 广告
        val rdd: RDD[String] = sc.textFile("data/agent.log")
        // 2.（（省份，广告），1）
        val splitRDD: RDD[((Int, Int), Int)] = rdd.map(s => {
            val split: Array[String] = s.split(" ")
            ((split(1).toInt, split(4).toInt),1)
        })
        // 3.转换结构后的数据进行分组聚合（（省份，广告），sum）
        val result: RDD[((Int, Int), Int)] = splitRDD.reduceByKey(_ + _)
        // （（省份，广告），sum）=> （省份，(广告，sum）)
        val newMapRDD = result.map {
            case ((prv, ad), i) => (prv, (ad, i))
        }
        // （省份，[(广告1，sum）,(广告2，sum）])
        val groupRDD: RDD[(Int, Iterable[(Int, Int)])] = newMapRDD.groupByKey()
        // 排序 取前三名
        val resultRDD: RDD[(Int, List[(Int, Int)])] = groupRDD.mapValues(
            iter => {
                iter.toList.sortBy(_._2)(Ordering.Int.reverse)
                  .take(3)
            }
        )

        resultRDD.collect().foreach(println)

        sc.stop()
    }


}
