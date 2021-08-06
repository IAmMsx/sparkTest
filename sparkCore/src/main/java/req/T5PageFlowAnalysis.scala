package req

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object T5PageFlowAnalysis {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("pageflow")
        val sc = new SparkContext(sparkConf)

        val actionRDD = sc.textFile("data/user_visit_action.txt")
        actionRDD.cache()

        val actionDataRDD: RDD[UserVisitAction] = actionRDD.map(
            action => {
                val datas = action.split("_")
                UserVisitAction(
                    datas(0),
                    datas(1).toLong,
                    datas(2),
                    datas(3).toLong,
                    datas(4),
                    datas(5),
                    datas(6).toLong,
                    datas(7).toLong,
                    datas(8),
                    datas(9),
                    datas(10),
                    datas(11),
                    datas(12).toLong,
                )
            }
        )
        actionDataRDD.cache()
        // 指定页面进行统计
        val ids = List[Long](1, 2, 3, 4, 5, 6, 7)
        val okIds: List[(Long, Long)] = ids.zip(ids.tail)
        // 求分母
        val pageIdToCntMap: Map[Long, Long] = actionDataRDD.filter(
            action=>{
                ids.init.contains(action.page_id)
            }
        ).map(
            action => {
                (action.page_id, 1L)
            }
        ).reduceByKey(_ + _).collect().toMap

        // 求分子
        val sessionRDD = actionDataRDD.groupBy(_.session_id)
        val mapRDD: RDD[(String, List[((Long, Long), Int)])] = sessionRDD.mapValues(
            itor => {
                val sortList = itor.toList.sortBy(_.action_time)
                val flowIds = sortList.map(_.page_id)
                val pageFlowIds = flowIds.zip(flowIds.tail)

                // 不合法的跳转进行过滤
                pageFlowIds.filter(okIds.contains(_))
                  .map((_, 1))
            }
        )
        val dataRDD: RDD[((Long, Long), Int)] = mapRDD.flatMap(_._2).reduceByKey(_ + _)

        // 求转换率
        dataRDD.foreach {
            case ((pageID1, pageID2), sum) =>
                val fenmu = pageIdToCntMap.getOrElse(pageID1, 0L)
                println(s"页面${pageID1}跳转到${pageID2}转换率为:" + sum.toDouble / fenmu)
        }
        sc.stop()
    }

    case class UserVisitAction(
                                date: String, //用户点击行为的日期
                                user_id: Long, //用户的 ID
                                session_id: String, //Session 的 ID
                                page_id: Long, //某个页面的 ID
                                action_time: String, //动作的时间点
                                search_keyword: String, //用户搜索的关键词
                                click_category_id: Long, //某一个商品品类的 ID
                                click_product_id: Long, //某一个商品的 ID
                                order_category_ids: String, //一次订单中所有品类的 ID 集合
                                order_product_ids: String, //一次订单中所有商品的 ID 集合
                                pay_category_ids: String, //一次支付中所有品类的 ID 集合
                                pay_product_ids: String, //一次支付中所有商品的 ID 集合
                                city_id: Long
                              ) //城市 id

}
