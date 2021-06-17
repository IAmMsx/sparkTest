package IterableTest

object E2_WordCountCommon {
    def main(args: Array[String]): Unit = {
        val stringList: List[String] = List(
            "hello",
            "hello world",
            "hello scala",
            "hello spark from scala",
            "hello flink scala"
        )
        // 1. 切分字符串
        val flatStringList: List[String] = stringList.flatMap((_: String).split(" "))

        // 2. 相同单词分组
        val groupStringMap: Map[String, List[String]] = flatStringList.groupBy((word: String) => word)

        // 3. 对分组之后的List取长度，得到每个单词的个数
        val countMap: Map[String, Int] = groupStringMap.map((kv: (String, List[String])) => (kv._1, kv._2.size))

        // 4. 将map转换为list并排序取前三
        val sortedlist: List[(String, Int)] = countMap.toList
          .sortWith((_: (String, Int))._2 > (_: (String, Int))._2)
          .take(3)
        println(sortedlist)

    }

}
