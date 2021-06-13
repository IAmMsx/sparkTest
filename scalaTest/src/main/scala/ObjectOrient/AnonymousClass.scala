package ObjectOrient

// 匿名子类 多针对抽象类或者接口
object AnonymousClass {
    def main(args: Array[String]): Unit = {
        val person: Person5 = new Person5 {
            override var name: String = "Tom"

            override def eat(): Unit = {
                println(s"$name eat")
            }
        }

        println(person.name)
        person.eat()
    }

}

abstract class Person5 {
    var name: String

    def eat(): Unit
}
