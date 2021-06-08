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

        println("******************************111111111111111")
        // 2. 自定义while // 柯里化
        n = 10
        whileTest(n>=1)({
            println(n)
            n -= 1
        })

        @tailrec
        def whileTest(condition: =>Boolean)(temp: => Unit): Unit = {
            if (condition) {
                temp
                whileTest(condition)(temp)
            }
//            else println(n)
        }

        // 3. 用闭包实现一个函数，将代码块作为参数传入
        def myWhileTest(condition: => Boolean): (=> Unit) => Unit = {
            @tailrec
            def deLoop(op: => Unit): Unit = {
                if (condition) {
                    op
                    //                    myWhileTest(condition)(op)
                    deLoop(op)
                }
            }

            deLoop
        }

        println("***********************************")
        n = 10
        myWhileTest(n >= 1)({
            println(n)
            n -= 1
        })

        // 4. 匿名函数实现
        println("***********************************44444444444444")

        def myWhileTest2(condition: => Boolean): (=> Unit) => Unit = {
            op => {
                if (condition) {
                    op
                    myWhileTest2(condition)(op)
                    //                    deLoop(op)
                }
            }
        }

        n = 10
        myWhileTest2(n >= 1)({
            println(n)
            n -= 1
        })


    }


}
