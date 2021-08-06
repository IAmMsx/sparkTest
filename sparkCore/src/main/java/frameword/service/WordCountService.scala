package frameword.service

import frameword.common.TService
import frameword.dao.WordCountDao
import org.apache.spark.rdd.RDD

// 服务层
class WordCountService extends TService{

    private val wordCountDao = new WordCountDao()

    def dataAnalysis(): Array[(String, Int)] ={

        val lines = wordCountDao.readFile("data/2.txt")
        // 2.分词
        val words: RDD[String] = lines.flatMap((_: String).split(" "))
        // 3.将数据单词分组
        val wordGroup: RDD[(String, Iterable[String])] = words.groupBy((word: String) => word)
        // 4.分组后的数据进行转换（name,count）
        val wordToCount: RDD[(String, Int)] = wordGroup.map {
            case (word, list) =>
                (word, list.size)
        }
        val array: Array[(String, Int)] = wordToCount.collect()
        array
    }
}
