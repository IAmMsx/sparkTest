package IterableTest

object T14_HighLevelFunction {
    def main(args: Array[String]): Unit = {
        val listTest = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

        // 1. 过滤
        // 选取偶数
        val evenList: List[Int] = listTest.filter((_: Int) % 2 == 0)
        println(evenList)

        // 2. map
        // 把集合中每个数×2
        println("***************************")
        val mapTest1: List[Int] = listTest.map((_: Int) * 2)
        println(mapTest1)
        println(listTest.map((x:Int) => x * x))

        // 3. 扁平化
        println("***************************")
        val nestedList = List(List(1, 2, 3), List(5, 6), List(10, 7))

        val flatList: List[Int] = nestedList.head ::: nestedList(1) ::: nestedList(2)
        println(flatList)

        val flatList2: List[Int] = nestedList.flatten
        println(flatList2)

        // 4. 扁平映射
        // 将一组字符串进行分词,并保存成单词列表
        println("***************************")
        val strings = List("hello world", "hello scala", "study everyday", "hello java")
        val splitList: List[Array[String]] = strings.map((string: String) => string.split(" "))

        val flatten: List[String] = splitList.flatten
        println(flatten)
        println("***************************")

        val flatMapList:List[String] = strings.flatMap((_:String).split(" "))
        println(flatMapList)
    }

}
