package PatternMatch

object MatchObject {
    def main(args: Array[String]): Unit ={
        val tom: Student = Student("Tom", 18)

        val result: Unit = tom match {
            case Student("Tom",18) => println("1")
            case _ => println("0")
        }

    }

}

class Student(val name:String,val age:Int)

object Student{
    def apply(name: String, age: Int): Student = new Student(name, age)

    // 需要实现一个unapply 进行对对象属性进行拆解
    def unapply(arg: Student): Option[(String, Int)] = {
        if (arg==null){
            None
        } else
            Some((arg.name,arg.age))
    }
}
