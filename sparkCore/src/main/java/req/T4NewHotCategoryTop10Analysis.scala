package req

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object T4NewHotCategoryTop10Analysis {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
        val sc = new SparkContext(sparkConf)
        // 点击转换成（id,(1,0,0)）
        // 下单转换成（id,(0,1,0)）
        // 支付转换成（id,(0,0,1)）
        val actionRDD = sc.textFile("data/user_visit_action.txt")

        // 创建累加器对象
        val acc = new HotCategoryAccumulator()
        // 向spark注册
        sc.register(acc, "hotCategory")
        actionRDD.foreach(
            action => {
                val datas = action.split("_")
                if (datas(6) != "-1") {
                    // 点击
                    acc.add(datas(6), "click")
                } else if (datas(8) != "null") {
                    // 下单
                    val ids = datas(8).split(",")
                    ids.foreach(acc.add(_, "order"))
                } else if (datas(10) != "null") {
                    val ids = datas(10).split(",")
                    ids.foreach(acc.add(_, "pay"))
                }
            }
        )

        val accval = acc.value
        val categories = accval.values

        val sort = categories.toList.sortWith(
            (left, right) => {
                if (left.clickCnt > right.clickCnt) true
                else if (left.clickCnt == right.clickCnt) {
                    if (left.orderCnt > right.orderCnt) true
                    else if (left.orderCnt == right.orderCnt) left.payCnt > right.payCnt
                    else false
                }
                else false
            }
        )
        // 6. 将结果采集到控制台并打印
        sort.take(10).foreach(println)
        sc.stop()
    }

    case class HotCategory(id: String, var clickCnt: Int, var orderCnt: Int, var payCnt: Int) {
        def clickAdd(): Unit = clickCnt += 1

        def orderAdd(): Unit = orderCnt += 1

        def payAdd(): Unit = payCnt += 1


    }

    // 自定义累加器 无需shuffle操作
    //      IN: (ID，行为类型)
    //      OUT: mutable.Map[String,HotCategory]
    class HotCategoryAccumulator extends AccumulatorV2[(String, String), mutable.Map[String, HotCategory]] {
        private val out: mutable.Map[String, HotCategory] = mutable.Map[String, HotCategory]()

        override def isZero: Boolean = {
            out.isEmpty
        }

        override def copy(): AccumulatorV2[(String, String), mutable.Map[String, HotCategory]] = {
            new HotCategoryAccumulator()
        }

        override def reset(): Unit = {
            out.clear()
        }

        override def add(v: (String, String)): Unit = {
            val cid = v._1
            val actionType = v._2
            val category = out.getOrElse(cid, HotCategory(cid, 0, 0, 0))

            if (actionType == "click") category.clickAdd()
            else if (actionType == "order") category.orderAdd()
            else if (actionType == "pay") category.payAdd()

            out.update(cid, category)
        }

        override def merge(other: AccumulatorV2[(String, String), mutable.Map[String, HotCategory]]): Unit = {
            val map1 = this.out
            val map2 = other.value

            map2.foreach {
                case (cid, hc) => {
                    val category = map1.getOrElse(cid, HotCategory(cid, 0, 0, 0))
                    category.clickCnt += hc.clickCnt
                    category.orderCnt += hc.orderCnt
                    category.payCnt += hc.payCnt
                    map1.update(cid, category)
                }
            }
        }

        override def value: mutable.Map[String, HotCategory] = out
    }

}
