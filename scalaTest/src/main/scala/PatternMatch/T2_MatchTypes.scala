package PatternMatch

object T2_MatchTypes {
    def main(args: Array[String]): Unit = {
        // 1. 匹配类型
        def describeType(x: Any): String = x match {
            case i: Int => "Int" + i
            case s: String => "String"
            case list: List[String] => ""
            case array: Array[Int] => "ss"
            case _ => ""
        }

        // 2. 匹配数组
        def describeArray(arr: Array[Any]): String = arr match {
            case Array(0, _*) => "0开头的数组"
            case Array(x, y) => "两元素数组"
            case Array(x, 1, z) => "中间元素为1的三元素数组"
            case _ => ""
        }

        println(describeArray(Array(0, 1, 2, 3)))
        println(describeArray(Array(1, 2)))

        // 3. 列表匹配 特殊的
        val list = List(1, 2, 3, 4, 5)
        list match {
            // rest为list first second为元素，匹配至少有两个元素的list
            case first :: sceond :: rest => println("1")
            case _ => println("2")
        }

        // 4. 特殊元组匹配
        val (x, y, z) = (1, 2, 3)
        println(x + " " + " " + y + " " + z)

        val _ :: sec :: rest = List(23, 15, 11, 3)

        // 5. for 中的元组匹配
        val listTest = List(("a", 2), ("b", 3), ("c", 5))
        // 5.1 元组形式的for
        for ((x, y) <- listTest) {
            println(x + "**" + y)
        }
        // 5.2 可以不考虑某个位置的变量，只遍历key或者value
        for ((word, _) <- listTest) {
            println(word)
        }
        // 5.3 可以指定某个位置的值必须是多少
        for (("a", count) <- listTest)
            println(count)

        println("*****************")
        for ((word, count) <- listTest) {
            if (count < 5)
                println(word, count)
        }

    }

}
