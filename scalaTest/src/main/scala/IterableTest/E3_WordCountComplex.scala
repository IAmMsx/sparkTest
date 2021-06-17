package IterableTest

object E3_WordCountComplex {
    def main(args: Array[String]): Unit = {
        val stringList = List(
            ("hello", 1),
            ("hello world", 2),
            ("hello scala", 1),
            ("hello spark from scala", 3),
            ("hello flink scala", 2)
        )
        // 1. 法一：直接展开为普通版本
        val newTupleList: List[String] = stringList.map(
            (kv: (String, Int)) => {
                (kv._1.trim + " ") * kv._2
            }
        )
        val wordCountList:List[(String, Int)] =newTupleList
          .flatMap((_: String).split(" "))
          .groupBy((word: String) =>word)
          .map((kv: (String, List[String])) => (kv._1,kv._2.size))
          .toList
          .sortWith((_: (String, Int))._2>(_: (String, Int))._2)
          .take(3)
        println(wordCountList)

        println("*******************************")
        // 2. 基于预统计的结果进行转换
        // 2.1 字符串打散并结合对应的个数包装成二元组
        val preCountList:List[(String,Int)] = stringList.flatMap(
            (kv: (String, Int)) =>{
                val strings: Array[String] = kv._1.split(" ")
                strings.map((string: String) => (string,kv._2))
            }
        )
//        println(preCountList)
        // 2.2 对二元组按照单词进行分类
        val preCountMap:Map[String,List[(String,Int)]] = preCountList.groupBy((_: (String, Int))._1)
//        println(preCountMap)

        // 2.3 叠加每个单词预统计的个数值
        val countMap: Map[String, Int] = preCountMap
          .transform(
            (_: String, value: List[(String, Int)]) => {
            value.map((_: (String, Int))._2).sum
        })
//        println(countMap)
        // 2.4 排序取前三个
        val resultList: List[(String, Int)] = countMap
          .toList
          .sortWith((_: (String, Int))._2 > (_: (String, Int))._2)
          .take(3)
        println(resultList)

    }
}
