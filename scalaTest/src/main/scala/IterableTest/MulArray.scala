package IterableTest

object MulArray {
    def main(args: Array[String]): Unit = {
        // 1. 创建二维数组
        val arr: Array[Array[Int]] = Array[Array[Int]](Array[Int](1, 2, 3), Array[Int](4, 5, 6))
        val array: Array[Array[Int]] = Array.ofDim[Int](2, 2)

        // 2. 访问元素
        array(0)(0) = 1
        for (i <- arr.indices; j <- arr(i).indices) {
            print(arr(i)(j) + "\t")
            if (j == arr(i).length - 1) println()
        }

        arr.foreach((line: Array[Int]) => line.foreach(println))

        arr.foreach((_: Array[Int]).foreach(println))
        println("**********************")
        arr.foreach((line: Array[Int]) => {
            line.foreach(print); println()
        })
        // 3.

    }

}
