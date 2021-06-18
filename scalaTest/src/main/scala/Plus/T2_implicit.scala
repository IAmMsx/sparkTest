package Plus

import scala.language.implicitConversions

object T2_implicit {
    def main(args: Array[String]): Unit = {

        // 1. 隐式函数
        implicit def converte(num:Int):MyRichInt = new MyRichInt(num)
        println(12.myMax(15))

        // 2. 隐式类
        implicit class MyRichInt2(val self: Int) {
            def myMax2(n: Int): Int = if (n < self) self else n

            def myMin2(n: Int): Int = if (n < self) n else self
        }
        println(12.myMax2(15))

        // 3. 隐式参数
        implicit val str:String = "Tom"
        implicit val age:Int = 19

        def sayHello(implicit name:String):Unit = {
            println("hello "+name)
        }

        sayHello

        // 简便写法
        def hiAge():Unit = {
            println("age" + implicitly[Int])
        }
        hiAge()
    }

}
class MyRichInt(val self: Int) {
    def myMax(n: Int): Int = if (n < self) self else n

    def myMin(n: Int): Int = if (n < self) n else self
}

// 自定义类
