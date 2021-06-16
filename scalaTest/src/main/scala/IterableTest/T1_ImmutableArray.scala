package IterableTest

/*
    Array 定长不可变 推荐通过运算符来操作数组
    增:(添加元素后返回新数组,原数组是不可变的)
        1. 添加数据到末尾 arr.:+(value) 返回新数组
        2. 添加数据到开头 arr.+:(value) 返回新数组
        或者省略.与()
        3. arr :+ value 同1
        4. value +: arr 同2 注意: 必须value在前
           支持连加 value1 +: value2 +: arr :+ value3 :+ value4
    改: 1. arr(index) =
        2. arr.update(index,value)
    查: arr(index)
    遍历: 4.
 */
object T1_ImmutableArray {
    def main(args: Array[String]): Unit = {
        val arr = new Array[Int](10)
        //        println(arr.length) // 10
        // 2. 另一种创建方式 调用Array伴生对象中的apply方法
        val arr2: Array[Int] = Array(12, 22, 32, 33, 59)
        println(arr2.mkString("Array(", ", ", ")"))

        // 3. 访问数组中的元素
        arr(0) = 15
        arr.update(1, 2)
        println(arr(0))
        println(arr(1))

        // 4. 数组遍历
        // 1) 普通循环:
        println("**********************")
        for (i <- arr.indices) {
            println(arr(i))
        }
        // 2). 遍历所有元素 增强for循环
        println("**********************")
        for (elem <- arr2) {
            println(elem)
        }
        // 3). itertor 迭代器
        println("**********************")
        val iter: Iterator[Int] = arr.iterator
        while (iter.hasNext)
            println(iter.next())
        // 4). foreach
        println("**********************")
        arr2.foreach((elem: Int) => println(elem))
        arr2.foreach(println)

        // 5. 添加元素 添加元素后返回新数组
        println("**********************")
        val arrAdd: Array[Int] = arr2.:+(73)
        println(arr2.mkString(","))
        println(arrAdd.mkString(","))

        val arrAddHead: Array[Int] = arrAdd.+:(1)
        println(arrAddHead.mkString(","))

        val newArr: Array[Int] = arr2 :+ 15
        println(newArr.mkString(","))
        val newArr2: Array[Int] = 19 +: 25 +: newArr :+ 99
        println(newArr2.mkString(","))


    }
}
