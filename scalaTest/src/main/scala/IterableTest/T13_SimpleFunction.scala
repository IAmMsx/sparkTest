package IterableTest

object T13_SimpleFunction {
    def main(args: Array[String]): Unit = {
        val list1 = List(1, 5, 6, 7, 9, 8, 1)

        val list2 = List(("e", 5), ("b", 6), ("f", 1), ("c", 10), ("a", 3), ("e", 2))
        // 1. 求和 list.sum
        var sum = 0
        list1.foreach(sum += (_: Int))
        println(sum)

        println(list1.sum)
        // 2. 求乘积 list.product
        println(list1.product)
        // 3. 最大值
        println("********************************")
        println(list1.max)
        println(list2.maxBy((_: (String, Int))._2))
        // 4. 最小值
        println("********************************")
        println(list1.min)
        println(list2.minBy((_: (String, Int))._2))
        // 5. 排序
        // 5.1 list.sorted
        println("********************************")
        println(list1.sorted)
        // 从大到小逆序
        println(list1.sorted.reverse)

        list1.sorted(Ordering[Int].reverse)

        // 5.2 list.sortBy
        println(list2.sortBy((_: (String, Int))._2))
        println(list2.sortBy((_: (String, Int))._1)(Ordering[String].reverse))

        // 5.3 sortWith
        println("*********************************")
        println(list1.sortWith((a: Int, b: Int) => a > b))
        println(list1.sortWith((_: Int) < (_: Int)))
    }

}
