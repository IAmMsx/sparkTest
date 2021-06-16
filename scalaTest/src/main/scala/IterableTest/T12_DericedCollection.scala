package IterableTest

object T12_DericedCollection {
    def main(args: Array[String]): Unit = {
        val list1 = List(1, 5, 6, 7, 9, 8)
        val list2 = List(3, 7, 8, 11, 23, 456)
        //  1. 获取集合的头
        println(list1.head)
        //  2. 获取集合的尾 除了头的都是尾
        println(list1.tail)
        //  3. 集合最后一个数据
        println(list1.last)
        //  4. 集合初始数据 不包含最后一个元素
        println(list1.init)
        //  5. 反转
        val reverseList1: List[Int] = list1.reverse
        println(reverseList1)
        //  6. 取前(后)n个元素
        val takeList1: List[Int] = list1.take(3)
        println(takeList1)
        val takeRightList1: List[Int] = list1.takeRight(4)
        println(takeRightList1)
        //  7. 去掉前(后)n个元素
        val dropList1: List[Int] = list1.drop(2)
        println(dropList1)

        val dropRightList1: List[Int] = list1.dropRight(2)
        println(dropRightList1)
        //  8. 并集
        val unionList: List[Int] = list1.union(list2)
        println(unionList)
        // 如果两个set 则会自动去重

        //  9. 交集
        val intersectionList: List[Int] = list1.intersect(list2)
        println(intersectionList)
        //  10. 差集  List1.diff(List2) 属于list1但不属于list2的元素
        val diffList: List[Int] = list1.diff(list2)
        println(diffList)

        //  11. 拉链 返回一个二元组
        println("zip:" + list1.zip(list2))

        //  12. 滑窗 list.sliding(size,step)
        val array: Array[List[Int]] = list1.sliding(2).toArray
        println(array.mkString("Array(", ", ", ")"))

        for (elem <- list1.sliding(3, 2)) println(elem)
    }
}
