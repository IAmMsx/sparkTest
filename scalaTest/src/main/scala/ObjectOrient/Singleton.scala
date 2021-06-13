package ObjectOrient

object Singleton {
    def main(args: Array[String]): Unit = {
        val s1: Student12 = Student12.getInstance()
        val s2: Student12 = Student12.getInstance()
        println(s1 == s2)
    }

}

class Student12 private(name: String, age: Int) {
    def printInfo(): Unit = {
        println(s"Student:$name $age ${Student11.school}")
    }
}

// 饿汉式
//object Student12 {
//    private val studentTest: Student12 = new Student12("msx", 22)
//
//    def getInstance(): Student12 = studentTest
//}

// 懒汉式
object Student12{
    private var Student:Student12 = _
    def getInstance():Student12 ={
        if(Student == null){
            Student = new Student12("msx",22)
        }
        Student
    }
}