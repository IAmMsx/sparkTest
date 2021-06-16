package IterableTest

import scala.collection.mutable

object T9_MutableMap {
    def main(args: Array[String]): Unit = {
        // 1.
        val map1: mutable.Map[String, Int] = mutable.Map("a" -> 13,"hello" -> 3)
        println(map1)
        println(map1.getClass)

        // 2. 添加元素
        map1.put("b",2)
        map1.put("c",12)
        println(map1)

        // 3. 删除元素
        map1.remove("a")
        println(map1)

        // 4. 修改/插入元素
        map1.update("a", 13)
        map1.update("a", 1)
            // 第一个插入 ("a" -> 13) 第二个修改"a"对应的value
        println(map1)

        // 5. 合并两个Map
        // map1 ++= map2
        // map1中没有的key直接添加,已有的key修改为map2中对应的value

    }

}
