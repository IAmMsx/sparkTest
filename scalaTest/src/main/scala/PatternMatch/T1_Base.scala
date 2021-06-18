package PatternMatch

object T1_Base {
    def main(args: Array[String]): Unit = {
        val x = 2
        val y: String = x match {
            case 1 => "one"
            case 2 => "two"
            case _ => "other" // 同default
        }
        println(y)

        //
        def matchDualOp(op: Char,a:Int,b:Int):Int = op match {
            case '+' => a+b
            case '-' => a-b
            case '*' => a*b
            case '/' => a/b
            case _ => -1
        }

        println(matchDualOp('*', 2, 3))

        // 3. 模式守卫
        // 求一个整数的绝对值
        def abs(num:Int):Int = {
            num match {
                case i if i>=0 => i
                case i if i<0 => -i
            }
        }

        val i: Int = abs(-1)
        val i1: Int = abs(1)
        println(i)
        println(i1)
    }
}
