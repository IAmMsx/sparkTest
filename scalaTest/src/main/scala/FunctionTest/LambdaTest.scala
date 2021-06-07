package FunctionTest

object LambdaTest {
    def main(args: Array[String]): Unit = {
        val stringToUnit: String => Unit = (name: String) => {
            println(name)
        }
        val fun: String => Unit = stringToUnit
        fun("masx")

        // 定义一个函数 以函数作为参数输入
        def f(func: String => Unit): Unit = {
            func("msx")
        }

        f(fun)
        f((name: String) => {
            println(name)
        })

        // 匿名函数的简化
        /**
         * 1. 参数类型可以省略 根据形参自动推导
         * 2. 类型省略之后 只有一个参数可以省略圆括号；没有参数或者参数大于一不可省略
         * 3. 匿名函数只有一行可以省略大括号
         * 4. 如果参数只出现一次，参数省略且后面的参数可以用_代替
         */
        f((name: String) => println(name))
        println("***************************")
        f(println(_: String))
        println("***************************")
        // 5. 如果可以推断出当前传入的是函数体而不是调用语句，可以直接省略下划线
        f(println)


        // 例子 定义一个二元运算函数，数据为1和2，具体运算通过参数传入
        def dualFunctionOneAndTwo(fun: (Int, Int) => Int): Int = {
            fun(1, 2)
        }

        //        val add = (a: Int, b: Int) => a + b
        println("***************************")
        val add: (Int, Int) => Int = (a: Int, b: Int) => a + b
        println(dualFunctionOneAndTwo(add))

        println("***************************")
        val minus: (Int, Int) => Int = (a: Int, b: Int) => a - b
        println(dualFunctionOneAndTwo(minus))

        // 简化
        println(dualFunctionOneAndTwo((a: Int, b: Int) => a + b))
        println(dualFunctionOneAndTwo((_: Int) + (_: Int)))

    }

}
