package FunctionTest

object LazyTest {
    def main(args: Array[String]): Unit = {

        lazy val result: Int = sum(13, 14)
        println("1.//*/**/*/*")
        println(s"2,result$result")

        def sum(a: Int, b: Int): Int = {
            println("3. ==========")
            a + b
        }
    }
}
