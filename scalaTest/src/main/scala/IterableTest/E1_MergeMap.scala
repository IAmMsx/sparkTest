package IterableTest

import scala.collection.mutable

object E1_MergeMap {
    def main(args: Array[String]): Unit = {
        val map1 = Map("a" -> 1, "b" -> 3, "c" -> 6)
        val map2: mutable.Map[String, Int] = mutable.Map("a" -> 6, "b" -> 2, "c" -> 9, "d" -> 3)

        // 初始状态为map，操作对象为键值对，不可用fold fold要求二者相同
        val map3: mutable.Map[String, Int] = map1.foldLeft(map2)((mergeMap: mutable.Map[String, Int], keyValue: (String, Int)) => {
            val key: String = keyValue._1
            val value: Int = keyValue._2
            mergeMap(key) = mergeMap.getOrElse(key, 0) + value
            mergeMap
        })

        val map4: collection.Map[String, Int] = map3.filterKeys((_: String) < "c")

        println(map4)
        println(map3)

    }

}
