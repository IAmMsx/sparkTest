package PatternMatch

object T4_MatchCaseClass {
    def main(args: Array[String]): Unit = {
        val tom: Student1 = Student1("Tom", 18)

        val result: Unit = tom match {
            case Student1("Tom",18) => println("1")
            case _ => println("0")
        }
    }

}

//  定义为样例类
//  无需显式实现apply 与 unapply
case class Student1(name:String, age:Int)
