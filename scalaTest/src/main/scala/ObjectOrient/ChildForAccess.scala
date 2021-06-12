package ObjectOrient

object ChildForAccess {
    def main(args: Array[String]): Unit = {
        val person = new Person()
        person.printInfo()
    }

}

// 定义一个父类
class Person{
    // private 只能在类内部与伴生对象中可用
    private var idCard:String = "4444"
    // protected 同类与子类可用
    protected var name:String = "alice"
    // 不写为public
    var sex:String = "female"
    // private[包名] 包名下的其他类可以访问
    private[ObjectOrient] var age:Int = 18

    override def toString: String = {
        s"idCard:$idCard"
    }
    def printInfo(): Unit = {
        println(s"Person:$idCard\t$name\t$sex\t$age")
    }
}