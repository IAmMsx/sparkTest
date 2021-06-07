package FunctionTest

object ControlAbstraction {
    def main(args: Array[String]): Unit = {
        // 1. 传值参数
        def f0(a: Int): Unit = {
            println(s"a:$a")
            println(s"a:$a")
        }

        def f1(): Int = {
            println("f1Diaoyong")
            12
        }

        f0(23)
        f0(f1())

        println("*************************************")
        // 2. 传名参数 传递的不是具体的值而是代码块
        def f2(a: => Int): Unit = {
            println(s"a:$a")
            println(s"a:$a")
        }

        f2({
            println("这是代码块")
            12
        })
        println("*************************************")
        f2(f1())


    }

}
