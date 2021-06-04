package ProcessControlTest

object BreakTest {
    def main(args: Array[String]): Unit = {
        // 1. 采用抛出异常的方式来退出循环
        try {
            for (i <- 1 until 5) {
                if (i == 3)
                    throw new RuntimeException

            println(i)}
        } catch {
            case e:Exception => //什么都不做
        }

        println("这是循环外的代码")

        // 2. 使用scala
    }

}
