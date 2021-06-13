package ObjectOrient

object AbstractClass {
    def main(args: Array[String]): Unit ={
        val student = new Student9
        student.eat()
        student.sleep()
    }

}

abstract class Person9 {
    // 非抽象属性
    val name: String = "person"
    //  抽象属性
    var age: Int

    //    非抽象方法
    def eat(): Unit = {

        println("person eat")
    }

    //    抽象方法
    def sleep(): Unit

}
// 定义具体实现子类
class Student9 extends Person9{
    // 实现抽象属性与方法
    override var age: Int = 18

    override def sleep(): Unit = {
        println("student sleep")
    }

    // 重写非抽象属性和方法
    override val name: String = "Student"

    override def eat(): Unit = {
        println("Student eat")
    }
}

