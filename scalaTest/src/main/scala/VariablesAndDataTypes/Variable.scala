package VariablesAndDataTypes

import helloworld.Student

/*
    声明变量时，类型可省略
    类型确定后就不能修改了，说明Scala是强数据类型语言
    变量声明时，必须要有初始值
    正在声明/定义一个变量时，可以使用var或者val来修饰，
        var修饰的变量可变，val修饰的变量不可变
 */
object Variable {
    def main(args: Array[String]): Unit = {
        // 声明一个变量的通用语法
        var a: Int = 10
        //      声明变量时，类型可省略
        var a1 = 10
        val b1 = 23
        //      类型确定后就不能修改了，说明Scala是强数据类型语言
        var a2 = 15 // 类型为Int
        //      变量声明时，必须要有初始值
        var a3: Int = 1

        //      var修饰的变量可变，val修饰的变量不可变
        a1 = 12
        //        b1 = 25

        val msx = new Student("msx", 22)
        msx.age = 23

    }

}
