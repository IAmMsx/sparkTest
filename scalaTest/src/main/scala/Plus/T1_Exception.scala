package Plus

object T1_Exception {
    def main(args: Array[String]): Unit ={
        try {
            val n: Int = 10 / 0
        } catch {
            case e:ArithmeticException =>
                println("算数异常")
            case e:Exception => println("一般异常")

        }finally {
            println("处理结束")
        }
    }


}
