package ObjectOrient

object ConstructorParams {
    def main(args: Array[String]): Unit = {

        val bob = new Student2("BOB", 25)
        println(s"name${bob.name} age${bob.age}")
        bob.name = "jerry"
        println(s"name${bob.name} age${bob.age}")
        val student3 = new Student3("BOB", 20)
        student3.printInfo()
    }

}

// 括号里是属性可以直接访问
class Student2(var name: String, var age: Int)

// 括号里为形参 外界无法访问
class Student3(name: String, age: Int) {
    def printInfo(): Unit = {
        println(s"name${this.name} age${this.age}")
    }
}

