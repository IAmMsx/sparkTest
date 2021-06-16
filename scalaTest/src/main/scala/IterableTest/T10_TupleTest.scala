package IterableTest

object T10_TupleTest {
    def main(args: Array[String]): Unit = {
        // 1. 创建元组
        val tuple: (String, Int, Char, Boolean) = ("hello", 100, 'a', true)
        println(tuple)

        // 2. 访问元组中的数据
        println(tuple._1)
        println(tuple.productElement(1)) // 从0开始

        //3. 遍历元组
        println("******************************")
        for (elem <- tuple.productIterator) println(elem)

        // 4. 嵌套元组
        val tuple1: (String, Int, Char, Boolean, (String, Int, Char)) = ("hello", 100, 'a', true, ("msx", 22, 'a'))

    }
}
