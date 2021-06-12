package ObjectOrient

import scala.beans.BeanProperty

object classTest {
    def main(args: Array[String]): Unit = {
        // 初始一个对象
        val student = new Student()
        //        name private属性 无法访问
        //        student.name
        println(student.getAge)
        student.sex = "female"
        println(student.sex)
        student.setAge(21)
        println(student.age)
    }
}

class Student {
    // 定义属性
    private var name: String = "sss"
    // 获取get set方法
    @BeanProperty
    var age: Int = _
    // _ 表示赋空值
    var sex: String = _

}