package ObjectOrient

object AccessTest {
    def main(args: Array[String]): Unit = {
        // 创建对象
        val person = new Person()
//        person.idCard error
//        person.name error
        println(person.age)
        println(person.sex)

        person.printInfo()
        println("***********************")

        val worker = new Worker()
        worker.printInfo()
    }
}

// 定义一个子类
class Worker extends Person{
    override def printInfo(): Unit = {
        // 私有属性 子类也无法访问
//        println(idCard)
        name = "Tom"
        age = 25
        sex = "male"
        println(s"Worker:$name\t$sex\t$age")

    }
}
