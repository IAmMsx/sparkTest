package IterableTest

import scala.collection.mutable.ListBuffer
/*
    ListBuffer :
    增 1. .append()
       2. .prepend()
       3. .insert()
       4. ListBuf1 ++ ListBuf2 同List中的++ 返回新的Listbuf
       5. ListBuf1 ++= ListBuf2 2不变,1变为1与2之和
          ListBuf1 ++=: ListBuf2 1不变,2变为1与2之和
    删 1. .remove()
       2. List -= value
    改 .updata()
    查
    插
    遍历
 */
object T5_ListBufferTest {
    def main(args: Array[String]): Unit = {
        // 1.
        val listBuffer1: ListBuffer[Int] = ListBuffer(1, 2, 3)
        val ListBuf2 = new ListBuffer[Int]()

        // 2. 添加元素
        listBuffer1.append(4,5)
        listBuffer1.prepend(0)
        println(listBuffer1)

        // 3. 合并ListBuf


    }

}
