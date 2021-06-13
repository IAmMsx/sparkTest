package ObjectOrient

object Object {
    def main(args: Array[String]): Unit = {
        val tom: Student11 = Student11.newStudent("Tom", 25)
        tom.printInfo()

        val jerry: Student11 = Student11.apply("Jerry", 25)
        jerry.printInfo()

        // 特别的 scala 底层对apply方法有优化 apply可以省略
        val msx: Student11 = Student11("msx", 22)
        msx.printInfo()
    }

}

// 构造器定义为private
class Student11 private(name: String, age: Int) {
    def printInfo(): Unit = {
        println(s"Student:$name $age ${Student11.school}")
    }
}

// 伴生对象 类似java中的static
object Student11 {

    val school: String = "HeBei University"

    def newStudent(name: String, age: Int): Student11 = new Student11(name, age)

    def apply(name: String, age: Int): Student11 = new Student11(name, age)

}