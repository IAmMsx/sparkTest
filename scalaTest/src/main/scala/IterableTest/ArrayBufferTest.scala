package IterableTest

import scala.collection.mutable.ArrayBuffer

/*
    ArrayBuffer 可变数组
    增
    删
    改
    查
    插
    遍历
 */
object ArrayBufferTest {
    def main(args: Array[String]): Unit ={
        //1.  创建可变数组
        val arr1 = new ArrayBuffer[Int]()
        val arr2: ArrayBuffer[Int] = ArrayBuffer(23, 25, 55, 68)

        println(arr1.mkString(","))
        println(arr2)

    }


}
