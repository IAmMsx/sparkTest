package VariablesAndDataTypes

import java.io.{File, PrintWriter}
import scala.io.Source

object FileIOTest {
    def main(args: Array[String]): Unit = {
        val source = Source.fromFile("scalaTest/src/main/resources/test.txt")
        source.foreach(print)

        // 2. 将数据写入文件
        val writer = new PrintWriter(new File("scalaTest/src/main/resources/output.txt"))
        writer.write("hello scala from java writer")
        writer.close()
        //

    }


}
