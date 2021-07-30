package ACC

import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object example {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("ACC")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(List(1, 2, 3, 4))
        val sumAcc: LongAccumulator = sc.longAccumulator("sum")

        rdd.foreach(sumAcc.add(_))

        val mapRDD = rdd.map(num => {
            sumAcc.add(num)
            num
        })
        // 累加器少加：转换算子调用累加器，如果没有行动算子，则不会执行
        //      多加：多次调用行动算子，则会执行多次
        // 一般情况下在行动算子中调用累加器
        println(sumAcc.value)


        sc.stop()
    }
}
