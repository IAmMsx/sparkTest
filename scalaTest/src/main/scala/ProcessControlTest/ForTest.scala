package ProcessControlTest

import scala.collection.immutable
import scala.language.postfixOps

object ForTest {
    def main(args: Array[String]): Unit = {
        // java for(int i=0;i<10;i++){Systom.out.println(i+"hello world")}

        // 1. 范围遍历
        for (i <- 1 to 10) { // 等价于 for(i<-1.to(10))  **包括10**
            println(i + "hello world")
        }
        println("**************************************")

        //        for (i <- Range(1,10)){// **不包括10**
        //            println(i)
        //        }

        for (i <- 1 until 10) { // **不包括10**
            println(i)
        }

        // 2. 集合遍历
        for (i <- Array(12, 34, 53)) {
            println(i)
        }

        // 3. 循环守卫

        //        for (i <- 1 to 3 if i != 2){
        //            println(i)
        //        }
        for (i <- 1 to 3 if i != 2) {
            println(i)
        }

        // 4. 循环步长
        println("**************************************")
        for (i <- 0 to 10 by 2)
            println(i)
        println("**************************************")

        for (i <- 1 to 10 reverse)
            println(i)

        // 5. 循环嵌套
        for (i <- 1 to 3)
            for (j <- 1 to 3)
                println(s"i:$i\tn:$j")

        println("**************************************")

        for (i <- 1 to 3; j <- 1 to 3)
            println(s"i:$i\tn:$j")

        // 6. 引入变量
        for {
            i <- 1 to 10
            j = 10 - i
        }
            println(i+"\t"+j)

        // 7. for 的返回值
        val b: immutable.IndexedSeq[Int] = for (i <- 1 to 10) yield i
        val c: immutable.IndexedSeq[Int] = for (i <- 1 to 10) yield i*i
        println(b)
        println(c)
    }


}
