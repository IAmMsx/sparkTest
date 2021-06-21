package DistributedTest

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor2 {
    def main(args: Array[String]): Unit = {
        // 启动服务器
        val server = new ServerSocket(8888)

        println("start")
        // 等待客户端的链接
        val client = server.accept()
        val in = client.getInputStream

        val objectInputStream = new ObjectInputStream(in)

        val task = objectInputStream.readObject().asInstanceOf[SubTask]
        val ints: List[Int] = task.compute()


        println("计算节点[8888]计算结果为：" + ints)

        objectInputStream.close()
        client.close()

        server.close()

    }

}
