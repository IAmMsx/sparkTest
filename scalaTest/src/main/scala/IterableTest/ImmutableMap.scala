package IterableTest
/*
    不可变map

 */
object ImmutableMap {
    def main(args: Array[String]): Unit = {
        // 1.
        val map1: Map[String, Int] = Map("a" -> 13,"hello" -> 3)
        println(map1)
        println(map1.getClass)

        // 2. 遍历
        map1.foreach(println)
        map1.foreach((kv:(String,Int)) => println(kv))

        // 3. 取mAP中所有的key或者value
        for (key <- map1.keys){
            println(s"key ----> ${map1.get(key)}")
        }

        // 4. 访问某一个key的value
        println(map1.get("a").get)
        println(map1("a"))

        println(map1.getOrElse("c", 0)) //如果没有对应的key 返回0

    }

}
