package FunctionTest

object FunctionParameter {
    def main(args: Array[String]): Unit = {
        // 1. 可变参数
        def f1(str: String*): Unit = {
            println(str)
        }

        f1("tom")
        f1("tom", "msx")

        println("***********************")
        // 2. 如果存在多个参数，可变参数一般放在最后
        def f2(str1: String, age: Int, str: String*): Unit = {
            println(s"str1:$str1\tage:$age\tstr:$str")
        }
        f2("ss",11)
        f2("ss",11,"msx","ssssss")

    }


}
