package frameword.application

import frameword.common.TApplication
import frameword.controller.WordCountController

object WordCountApplication extends App with TApplication{

    // 启动应用程序
    start (){
        val controller = new WordCountController()
        controller.execute()
    }
}
