package frameword.controller

import frameword.common.TController
import frameword.service.WordCountService

// 控制层
class WordCountController extends TController{
    private val wordCountService = new WordCountService()

    // 调度
    def execute(): Unit ={
        val array = wordCountService.dataAnalysis()

        array.foreach(println)
    }


}
