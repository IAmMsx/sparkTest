package ACC

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object bc {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Bc")
        val sc = new SparkContext(sparkConf)

        val rdd1 = sc.makeRDD(List(
            ("a", 1), ("b", 2), ("c", 3)
        ))

        val map = mutable.Map(("a", 4), ("b", 5), ("c", 6))

        // 封装广播变量
        val bc = sc.broadcast(map)
//        val rdd2 = sc.makeRDD(List(
//            ("a", 4), ("b", 5), ("c", 6)
//        ))
//
//        // join 数据量几何增长 不推荐
//        rdd2.join(rdd1).collect().foreach(println)

        rdd1.map({
            case (str, i) => {
                val i1 = bc.value.getOrElse(str, 0)
                (str,(i,i1))
            }
        }).collect().foreach(println)
        sc.stop()
    }

}
