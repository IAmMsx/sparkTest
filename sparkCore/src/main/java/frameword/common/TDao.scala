package frameword.common

import frameword.util.EnvUtil
import org.apache.spark.rdd.RDD

trait TDao {
    def readFile(path:String): RDD[String] ={
        EnvUtil.take().textFile(path)
    }

}
