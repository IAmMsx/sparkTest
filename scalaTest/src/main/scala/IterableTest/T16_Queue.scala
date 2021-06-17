package IterableTest

import scala.collection.mutable

object T16_Queue {
    def main(args: Array[String]): Unit = {
        val queue = new mutable.Queue[String]()

        queue.enqueue("a","b","c","z","d")

        println(queue)
        println(queue.dequeue())
        println(queue)
    }

}
