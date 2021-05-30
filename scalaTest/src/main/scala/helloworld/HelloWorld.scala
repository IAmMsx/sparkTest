package helloworld

/*
    object : 关键字，声明一个单例对象（伴生对象）
 */
object HelloWorld {
    /*
        main 方法：从外部可以直接调用执行的
        def 方法名(参数名：参数类型)：返回值类型 = { 方法体 }
     */
    def main(args: Array[String]): Unit = {
        println("hello world")
        System.out.println("hello scala from java")
    }
}
