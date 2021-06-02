package VariablesAndDataTypes

object OperatorTest {
    def main(args: Array[String]): Unit = {
        var s1:String = "hello"
        var s2:String = new String("hello")
        println(s1==s2)
        println(s1.equals(s2))
        println(s1.eq(s2))// 判断引用地址
    }
}
