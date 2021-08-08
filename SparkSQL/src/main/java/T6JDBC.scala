import org.apache.spark.SparkConf
import org.apache.spark.sql.{SparkSession, functions}

object T6JDBC {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("jdbc")
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        import spark.implicits._


        spark.close()
    }

}
