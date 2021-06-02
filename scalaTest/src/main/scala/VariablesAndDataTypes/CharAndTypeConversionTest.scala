package VariablesAndDataTypes

object CharAndTypeConversionTest {
    def main(args: Array[String]): Unit = {

        val c1: Char = 'a'
        println(c1)

        // 1.强制类型转换
        // java:int num = (int) 2.5
        // scala:var num:Int = 2.7.toInt

        // 1.1 高精度转为低精度，需要强制转换
        val n1: Int = -2.5.toInt
        println(n1)

        // 1.2 强转符号只针对于最近的操作数有效，使用小括号提升优先级
        val n2: Int = (2.6 + 3.7).toInt
        val n3: Int = 2.6.toInt + 3.7.toInt
        println(s"n2=$n2\tn3=$n3")

        // 1.3 数值类型与String类型转换
        // 数值转String
        var s1: String = n1 + ""
        var s2: String = n1.toString

        // String转数值
        val m:Int = "12".toInt

        /*
        Int 4字节 32位
        310 :0000 0000 0000 0000 0000 0001 0011 0110
        转为Byte 8位 截断
        0011 0110 -> 54
         */
        var x:Int = 310
        var b:Byte = x.toByte
        println(b)//54

    }
}
