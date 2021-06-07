package FunctionTest

import scala.annotation.tailrec

object MyWhile {
    def main(args: Array[String]): Unit = {
        var n = 10

        // 1. 常规while循环x
        while (n >= 1) {
            println(n)
            n -= 1
        }

        println("******************************")
        // 2. 自定义while
        n = 10
        whileTest(n)({
            println(n)
            n -= 1
        })

        @tailrec
        def whileTest(a: Int)(temp: => Unit): Unit = {
            if (n != 1) {
                temp
                whileTest(n)(temp)
            }
            else println(n)
        }

        // 3. 用闭包实现一个函数，将代码块作为参数传入

    }


}
