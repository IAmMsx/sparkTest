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


    }

}
