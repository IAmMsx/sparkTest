import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object T3UDF {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        import spark.implicits._

        val df = spark.read.json("data/user.json")
        df.createOrReplaceTempView("user")

        spark.udf.register("prefixName", (name: String) => {
            "Name:" + name
        })
        spark.sql("select age,prefixName(username) from user").show()
        spark.close()
    }

}
