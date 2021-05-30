package VariablesAndDataTypes

import scala.io.StdIn

object stdInTest {
    def main(args: Array[String]): Unit = {
        // shuru
        print("your name:")
        val name:String = StdIn.readLine()
        print("your age:")
        val age:Int = StdIn.readInt()
        println(f"${name}已经${age}岁了")
    }
}
