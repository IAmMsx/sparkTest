package FunctionTest

object FunctionAndMethod {
    def main(args: Array[String]): Unit = {
        // 定义函数
        def sayHi(name : String):Unit = {
            println("Hi, " + name)
        }

        // 调用函数
        sayHi("alice")

        FunctionAndMethod.sayHi("msx")
    }

    // 定义对象的方法
    def sayHi(name : String):Unit = {
        println("hi, " + name)
    }

}
