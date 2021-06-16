package IterableTest

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/*
    ArrayBuffer 可变数组 推荐调用方法来操作数组
    增 1. arr.append(values) 在数组末尾添加元素
       2. arr.prepend(values) 在数组开头添加元素
       3. arr.insert(index,values) 在index位置插入元素
       4. arr.insert(index,arr2) 在index位置插入arr2
    删 1. arr.remove(index,count) 从index开始删除count个元素,count省略的话默认为1
       2. arr -= value 删除数组中值为value的元素 若多个只删除第一个,若没有则不做操作
    改 arr.update(index,value)
    查 arr(index)
    遍历
 */
object T2_ArrayBufferTest {
    def main(args: Array[String]): Unit = {
        //1.  创建可变数组
        val arr1 = new ArrayBuffer[Int]()
        val arr2: ArrayBuffer[Int] = ArrayBuffer(23, 25, 55, 68)

        println(arr1.mkString(","))
        println(arr2)

        // 2. 添加元素
        println("*********************")
        val newArr1: ArrayBuffer[Int] = arr1 :+ 15 // :+ 主要针对不可变数组
        println(newArr1)

        arr1 += 19 // +=
        println(arr1)

        1 +=: arr1
        println(arr1)

        arr1.append(35)
        arr1.prepend(11, 76)
        arr1.insert(1, 13, 11,1)
        arr1.insertAll(arr1.length, newArr1)
        println(arr1)

        // 3. 删除元素
        println("*********************")
        arr1.remove(0, 2)
        println(arr1)

        arr1.-=(1)
        println(arr1)

        // 4. 可变数组转换为不可变
        println("*********************")
        val arr3: ArrayBuffer[Int] = ArrayBuffer(22, 23, 24)
        val arr4: Array[Int] = arr3.toArray
        println(arr4.mkString("Array(", ", ", ")"))
        // 5. 不可变数组转换为可变数组
        println("*********************")
        val buffer: mutable.Buffer[Int] = arr4.toBuffer
        println(buffer)

    }
}
