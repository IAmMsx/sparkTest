package FunctionTest

object FunctionSimplify {

    def main(args: Array[String]): Unit = {
        // 1 return可以省略 scala一般会使用函数的在最后一行代码作为返回值
        // 2 只有一行代码可以省略花括号
        // 3 返回值类型若可以推断出来也可以省略
        // 4 若有return 则返回值类型必须指定
        // 5 如果声明为Unit 使用return关键字也不起作用
        // 6 scala如果期望是无返回值类型，可以省略等号
        // 7 如果函数无参 但是声明了函数列表，那么调用时小括号可加可不加
        // 8 如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
        // 9 如果不关心名称 只关心逻辑处理 那么调用时小括号可加可不加
        def f9(name: String): Unit = {
            println(name)
        }

        // 匿名函数 或者叫做lambda表达式
        (name: String) => {
            println(name)
        }

        println("*****************")
        f9("mmmsx")
    }
}
