import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object T1Basic {
    def main(args: Array[String]): Unit = {

        // 创建SparkSQL的运行环境
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()
        import spark.implicits._

        // 执行逻辑操作
        // RDD
        // DataFrame
        val df = spark.read.json("data/user.json")
        //        df.show()
        // df ->SQL
        //        df.createOrReplaceTempView("user")
        //        spark.sql("select * from user").show()
        //        spark.sql("select max(age) from user").show()

        // df ->DSL
        // 如果涉及转换操作，需要引入转换规则
//        df.select("age","username").show()
//        df.select($"age"+1).show()


        // DataSet
        // DataFrame是特定泛型的DataSet
        val seq = Seq(1, 2, 3, 4)
        val ds = seq.toDS()
        ds.show()

        // 关闭环境
        spark.close()
    }

}
