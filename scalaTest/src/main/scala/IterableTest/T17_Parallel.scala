package IterableTest

import scala.collection.immutable
import scala.collection.parallel.immutable.ParSeq

object T17_Parallel {
    def main(args: Array[String]): Unit = {
        val result: immutable.IndexedSeq[String] = (1 to 100).map(
            (x: Int) => Thread.currentThread.getName
        )
        println(result)

        val result2: ParSeq[Long] = (1 to 100).par.map(
            (x: Int) => Thread.currentThread.getId
        )
        val result3: ParSeq[String] = (1 to 100).par.map(
            (x: Int) => Thread.currentThread.getName
        )

        println(result2)
        println(result3)


    }

}
