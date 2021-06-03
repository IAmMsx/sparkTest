package ProcessControlTest

import scala.io.StdIn

object IfElseTest {
    def main(args: Array[String]): Unit = {
        println("your age：")
        val age: Int = StdIn.readInt()

        // 1. 单分支
        if (age >= 10) {
            println("chengnian")
        }

        println("********************")
        //2.多分支
        if (age >= 10) {
            println(">=10")
        } else if (age > 60) {
            println(">=60")
        } else {
            println("<10")
        }

    }


}
