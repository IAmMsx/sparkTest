import T4UDAF.MyAvgUDAF
import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoder, Encoders, SparkSession, functions}
import org.apache.spark.sql.expressions.{Aggregator, UserDefinedAggregateFunction}

object T5UDAF1 {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        import spark.implicits._

        val df = spark.read.json("data/user.json")
        df.createOrReplaceTempView("user")

        spark.udf.register("ageAvg", functions.udaf(new MyAvgUDAF()))

        spark.sql("select ageAvg(age) from user").show()
        spark.close()
    }

    // 自定义聚合函数类
    // 1.继承org.apache.spark.sql.expressions.Aggregator 定义泛型
    // IN 输入的数据类型Long
    // BUF 缓冲区的数据类型
    // OUT 输出的数据类型Long
    // 2.重写方法
    case class Buff(var total: Long, var count: Long)

    class MyAvgUDAF extends Aggregator[Long, Buff, Long] {
        // zero：初始值或零值
        // 缓冲区的初始化
        override def zero: Buff = {
            Buff(0L, 0L)
        }

        // 根据输入的数据更新缓冲区数据
        override def reduce(buff: Buff, in: Long): Buff = {
            buff.total = buff.total + in
            buff.count = buff.count + 1
            buff
        }


        // 合并缓冲区
        override def merge(b1: Buff, b2: Buff): Buff = {
            b1.total = b1.total + b2.total
            b1.count = b1.count + b2.count
            b1
        }

        // 计算结果 缓冲区=>结果
        override def finish(buff: Buff): Long = {
            buff.total / buff.count
        }

        // 缓冲区的编码操作
        override def bufferEncoder: Encoder[Buff] = Encoders.product

        // 输出的编码操作
        override def outputEncoder: Encoder[Long] = Encoders.scalaLong
    }
}
