package helloworld

/**
 *
 * @param name:456
 * @param age:123
 */
class Student(name: String, var age: Int) {
    def printInfo(): Unit = {
        println(this.name + " " + this.age + " " + Student.school)
    }
}

// 引入伴生对象

/**
 *
 */
object Student {
    val school: String = "Hebei University"


    def main(args: Array[String]): Unit = {
        val msx = new Student("msx", 22)
        msx.printInfo()

    }

}
