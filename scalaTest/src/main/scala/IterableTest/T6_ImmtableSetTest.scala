package IterableTest
/*
    Set
 */
object T6_ImmtableSetTest {
    def main(args: Array[String]): Unit = {
//        1.
        val setTest = Set(1, 1, 2, 3, 2, 4)
        println(setTest)

        // 2. 添加
        val Set2: Set[Int] = setTest + 20
        println(Set2)

        // 3. 合并
        val set3 = Set(9, 8, 7)

        val set4: Set[Int] = set3 ++ Set2
        println(set4)

        // 4. 删除
        val set5: Set[Int] = set4 - 9
        println(set5)
    }

}
