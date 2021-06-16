package IterableTest

object T11_CommonOp {
    def main(args: Array[String]): Unit = {
        val list = List(1, 5, 6, 7, 9, 8)
        val set = Set(25, 33, 68, 99)
        // 1. 获取集合长度
        println(list.length)
        // 2. 获取集合大小
        println(set.size)
        // 3. 循环遍历
        for (elem <- list) {
            println(elem)
        }
        list.foreach(println)
        // 4. 迭代器
        for (elem <- list.iterator) {
            println(elem)
        }
        // 5. 生成字符串
        println(list)
        println(set)

        println(list.mkString(","))
        // 6. 是否包含
        println(list.contains(1))
        println(set.contains(1))
    }
}
