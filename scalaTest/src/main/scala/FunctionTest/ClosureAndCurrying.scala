package FunctionTest

object ClosureAndCurrying {
    def main(args: Array[String]): Unit = {
        def add(a: Int, b: Int): Int = {
            a + b
        }

        // 1. add 固定一个加数的场景
        def addByFour(b: Int): Int = {
            4 + b
        }

        // 2. 扩展固定加数改变的情况
        def addByFive(b: Int): Int = 5 + b

        // 3. 将固定加数作为另一个参数传入，但是是作为“第一层参数”传入
        def addByA(a: Int): Int => Int = {
            def addB(b: Int): Int = {
                a + b
            }

            addB
        }

        println(addByA(25)(25))

        val addByFour2: Int => Int = addByA(4)
        val addByFive2: Int => Int = addByA(5)

        println(addByFour2(25))
        println(addByFive2(25))

        // 4. lambda 表达式
        def addByA2(a: Int): Int => Int = (b: Int) => a + b

        def addByA3(a: Int): Int => Int = a + (_: Int)

        // 5. 柯里化
        def addCurrying(a: Int)(b: Int): Int = a + b

        val addByTwo: Int => Int = addCurrying(2)
        println(addByTwo(5))
        println(addCurrying(2)(5))

    }

}
