package ACC

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object wordcount {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("ACC")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List("hello spark", "hello scala"))

        val mapRDD: RDD[String] = rdd.flatMap(_.split(" "))

        // 创建累加器对象
        val wcACC = new MyAccculator()
        // 向spark进行注册
        sc.register(wcACC, "wordcountACC")
        mapRDD.foreach(
            word => {
                // 数据的累加
                wcACC.add(word)
            }
        )

        println(wcACC.value)

        // 获取累加结果


        sc.stop()
    }

    // 自定义累加器 继承AccumulatorV2
    // In:累加器输入的数据类型
    // OUT ： 累加器输出的数据类型
    class MyAccculator extends AccumulatorV2[String, mutable.Map[String, Long]] {

        private val wcMap: mutable.Map[String, Long] = mutable.Map[String, Long]()

        // 判断是否为初始状态
        override def isZero: Boolean = {
            wcMap.isEmpty
        }


        override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = {
            new MyAccculator()
        }

        override def reset(): Unit = {
            wcMap.clear()
        }

        // 获取累加器需要计算的值
        override def add(v: String): Unit = {
            val newCount = wcMap.getOrElse(v, 0L) + 1
            wcMap.update(v,newCount)
        }

        // 合并多个累加器
        override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = {
            val map1 = this.wcMap
            val map2 = other.value

            map2.foreach{
                case (word, count) =>{
                    val newCnt = map1.getOrElse(word,0L)+count
                    map1.update(word,newCnt)
                }
            }
        }

        override def value: mutable.Map[String, Long] = {
            wcMap
        }
    }

}
