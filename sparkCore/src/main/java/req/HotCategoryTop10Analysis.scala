package req

import org.apache.spark.{SparkConf, SparkContext}

object HotCategoryTop10Analysis {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
        val sc = new SparkContext(sparkConf)
        // TOP10热门品类

        // 1. 读取原始日志数据

        // 2. 统计品类的点击数量（品类ID,点击数量）

        // 3. 统计品类的下单数量（品类ID,下单数量）

        // 4. 统计品类的支付数量（品类ID,支付数量）

        // 5. 排序 取前十名
        //    点击数量 下单数量，支付数量
        //    元组排序，先比较第一个，再比较第二个，再比较第三个。

        // 6. 将结果采集到控制台并打印


        sc.stop()
    }

}
