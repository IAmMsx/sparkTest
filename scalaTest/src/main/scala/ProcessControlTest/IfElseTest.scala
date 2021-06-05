package ProcessControlTest

import scala.io.StdIn

object IfElseTest {
    def main(args: Array[String]): Unit = {
        //        println("your age：")
        //        val age: Int = StdIn.readInt()
        //
        //        // 1. 单分支
        //        if (age >= 10) {
        //            println("chengnian")
        //        }
        //
        //        println("********************")
        //        //2.多分支
        //        if (age >= 10) {
        //            println(">=10")
        //        } else if (age > 60) {
        //            println(">=60")
        //        } else {
        //            println("<10")
        //        }
        //
        // 可以有返回值 ifelse 返回最后一行的值
        // 不同的返回值 给一个公共父类
        val age = 8
        val result: Any = if (age >= 10) {
            println(">=10")
            ">=10"
        } else if (age > 60) {
            println(">=60")
            ">=60"
        } else {
            println("<10")
            10
        }
        println(s"result:$result")

        // java 三元运算符 a?b:c

        val res: String = if (age >= 18) "成年" else "未成年"
        println(res)

    }
}
