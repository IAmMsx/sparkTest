package IterableTest

/*
    list
    增 1. +:与:+ 同array
       2. value1 :: value2 ::Nil 返回List(value1,value2)
       3. list1 ::: list2 链接两列表 同 list1 ++ list2
    删
    查 list(index)
    插
    遍历 1. list.foreach
        2. list.for
 */
object ListTest {
    def main(args: Array[String]): Unit = {
        // 1. 创建一个list
        val listTest: List[Int] = List[Int](1, 2, 3)
        println(listTest)
        // 2. 访问元素和遍历
        println(listTest(1))
        for (elem <- listTest) {
            println(elem)
        }

        // 3. 添加元素
        val list2: List[Int] = listTest :+ 10
        val list3: Any = 10 +: listTest

        val list4: List[Int] = listTest.::(4)
        println(list4)

        val list5: List[Int] = 17 :: 38 :: 16 :: 2 :: 0 :: Nil
        println(list5)

        val list6: List[Int] = list5 ::: listTest // 同 list5 ++ listTest
        println(list6)


    }

}
