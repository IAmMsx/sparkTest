package FunctionTest

object CollectionOperationTest {
    def main(args: Array[String]): Unit = {
        // 定义一个数组
        val arr = Array(12, 45, 75, 98)

        // 对数组进行处理 将操作抽象出来 处理完毕之后的结果返回新的数组
        def arrayOperation(array: Array[Int], op: Int => Int): Array[Int] = {
            for (elem <- array) yield op(elem)
        }

        // 定义一个op操作 例如对取5余
        def op(a: Int): Int = {
            a % 5
        }

        val newArray = arrayOperation(arr, op)

        println(newArray.mkString("", ", ", ""))
//        println(arrayOperation(arr, a => a % 5).mkString("; "))
//        println(arrayOperation(arr, _ % 5).mkString("; "))
    }
}
