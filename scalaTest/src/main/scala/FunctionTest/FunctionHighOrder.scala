package FunctionTest

object FunctionHighOrder {
    def main(args: Array[String]): Unit = {
        def f(n: Int): Int = {
            println("f调用")
            n + 1
        }

        val result = f(123)
        println(result)

        // 1. 函数作为值传递
        val f1 = f _
        println(f1(15))

        // 2. 函数作为函数的参数进行传递
        def dualEval(op: (Int, Int) => Int, a: Int, b: Int): Int = {
            op(a, b)
        }

        def minus(a: Int, b: Int): Int = {
            a - b
        }

        println(dualEval((a, b) => a + b, 1, 2))
        println(dualEval(_ + _, 1, 2))

        println(dualEval(minus, 1, 2))

        // 3. 函数作为返回值
        println("************************")
        def f3(): Int => Unit = {
            def f4(a: Int): Unit = {
                println("F4" + a)
            }
            f4 // 直接返回函数
        }

        println(f3()(25)) // *离谱*


    }

}
