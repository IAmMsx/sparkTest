package ObjectOrient

object Constructor {
    def main(args: Array[String]): Unit = {
        val student1 = new Student1()
        val student2 = new Student1("Tom")
        val student3 = new Student1("Jerry",25)


    }

}

// 构造器测试类
class Student1() {
    //
    var name: String = _
    var age: Int = _

    println("1. 主构造方法被调用")

    // 辅助构造方法
    def this(name:String){
        this() // 直接调用主构造器
        println("2. ")
        this.name = name
        println(s"name$name  age$age")

    }

    def this(name:String,age:Int){
        this(name)
        println(" 3. ")
        this.age = age
        println(s"name$name  age$age")

    }

}
