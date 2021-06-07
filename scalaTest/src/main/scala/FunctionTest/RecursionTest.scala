package FunctionTest

import scala.annotation.tailrec

object RecursionTest {
    def main(args: Array[String]): Unit = {
        println(recursion(5))
        println(tailFact(5))

    }

    def recursion(i: Int): Int = {
        if (i == 0) return 1
        i * recursion(i - 1)
    }

    // 尾递归实现
    def tailFact(n: Int): Int = {
        @tailrec
        def loop(n: Int, result: Int): Int = {
            if (n == 0) return result
            loop(n - 1, result * n)
        }
        loop(n, 1)
    }


}
