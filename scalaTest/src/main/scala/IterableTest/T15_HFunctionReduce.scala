package IterableTest

object T15_HFunctionReduce {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

        // 1. reduce
        println(list.reduce((_: Int) + (_: Int)))

        // 2. reduceLeft
        list.reduceLeft(_ + _)
        list.reduceRight(_ + _)

        println("*************************")
        val list2 = List(3, 4, 5, 8, 10)
        println(list2.reduceRight((_: Int) - (_: Int))) //3-(4-(5-(8-10)))

        // 2. fold    list.fold(初始状态)(f)
        println("*************************")
        val foldSum: Int = list.fold(10)((_: Int) + (_: Int))

        println(list2.foldRight(11)((_: Int) - (_: Int))) // 3-(4-(5-(8-(10-11))))
        println(foldSum)
    }

}
