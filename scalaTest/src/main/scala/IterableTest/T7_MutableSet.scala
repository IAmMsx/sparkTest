package IterableTest

import scala.collection.mutable

object T7_MutableSet {
    def main(args: Array[String]): Unit = {
        // 1. 创建
        val set1: mutable.Set[Int] = mutable.Set(13, 23, 12)
        println(set1)

        // 2. 添加元素
        set1.add(11)
        println(set1)

        // 3. 删除元素
        set1.remove(11)
        println(set1)

        // 4. 合并两个Set
        val set2: mutable.Set[Int] = mutable.Set(1, 2, 3, 4, 5)

        set1 ++= set2
        println(set1)

    }

}
