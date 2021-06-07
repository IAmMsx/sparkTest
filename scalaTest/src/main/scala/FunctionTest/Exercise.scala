package FunctionTest

object Exercise {
    def main(args: Array[String]): Unit = {
        // 定义一个匿名函数，作为值赋给变量fun,函数有三个参数，分别为Int,String,Char，返回值为Boolean
        // 要求调用函数(0，“”，‘0’)得到返回值为true 其他情况返回false
        val fun: (Int, String, Char) => Boolean = (a: Int, b: String, c: Char) => {
            if (a.equals(0) && b.equals("") && c.equals('0'))
                true
            else
                false
        }

        println(fun(0, "", '0'))
        println(fun(0, "1", '0'))
        println(fun(0, "1", '4'))
        println(fun(10, "1", '4'))

        // 定义一个函数func，接受一个Int类型的参数，返回一个函数 f1
        // f1 接受一个String类型的参数，返回一个函数f2
        // f2 接受一个char型参数 返回一个Boolean
        // func(0)("")('0')wei True
        def func(a: Int): String => Char => Boolean = {
            def f1(string: String): Char => Boolean = {
                def f2(char: Char): Boolean = {
                    if (a.equals(0) && string.equals("") && char.equals('0'))
                        true
                    else false
                }

                f2
            }

            f1
        }

        println(func(0)("")('0'))
        println(func(1)("")('0'))
        println(func(0)(" ")('0'))
        println(func(0)("")('2'))

        // 简化 匿名函数 不需要返回值 等号改为=>
        def func2(a: Int): String => Char => Boolean = {
            s: String => c: Char => if (a.equals(0) && s.equals("") && c.equals('0')) true else false
            }

        // 柯里化
        def func3(a :Int)(s:String)(c:Char):Boolean = {
            if (a.equals(0) && s.equals("") && c.equals('0')) true else false
        }


    }

}
