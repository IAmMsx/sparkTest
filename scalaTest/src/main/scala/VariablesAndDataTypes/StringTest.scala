package VariablesAndDataTypes

object StringTest {
    def main(args: Array[String]): Unit = {
        // 1. 字符串：通过+连接
        val name1 = new String("alace")
        val name2: String = "alace"
        println(name2)

        val age: Int = 18
        println(age + " " + name2)
        // * 用于将一个字符串复制多次并拼接
        println(name2 * 3)

        // 2. printf用法：字符串 通过%传值
        printf("%d岁的%s在学习", age, name1)

        // 3. 字符串模板：通过$获取变量值
        println(s"${age}岁的${name1}在学习") // s""

        val num:Float = 2.3456f
        val num1:Double = 2.45645645
        println(f"The num is $num1%3.2f") // f""
        println(raw"The num is $num1%3.2f") // raw""

        // 3引号表示字符串，保持多行字符串的原格式输出
        val sql = s"""
           |select *
           |from
           |    student
           |where
           |    name = $name1
           |and
           |    age > $age
           |""".stripMargin
        println(sql)
    }
}
