import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object T2transform {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()
        import spark.implicits._

        // RDD<=>DataFrame
        val rdd = spark.sparkContext.makeRDD(List((1, "zhangsan", 30), (2, "lisi", 20)))
        val df = rdd.toDF("id", "name", "age")

        val rowRDD: RDD[Row] = df.rdd

        //DataFrame <=> DataSet
        val ds: Dataset[User] = df.as[User]
        val df1: DataFrame = ds.toDF()


        // RDD <=> DataSet
        val ds1 = rdd.map {
            case (id, name, age) => User(id = id, name = name, age = age)
        }.toDS()

        val userRDD: RDD[User] = ds1.rdd
    }

    case class User(id:Int,name:String,age:Int)
}
