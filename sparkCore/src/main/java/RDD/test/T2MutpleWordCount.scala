package RDD.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable


object T2MutpleWordCount {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
        val sc = new SparkContext(sparkConf)

        wordCount1(sc)
        println("*****************2")
        wordCount2(sc)
        println("*****************3")
        wordCount9(sc)

        sc.stop()


    }

    // groupBy
    def wordCount1(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val group: RDD[(String, Iterable[String])] = rdd.flatMap(_.split(" "))
          .groupBy(word => word)
        val value: RDD[(String, Int)] = group.mapValues(_.size)
        value.collect().foreach(println)
    }

    // groupByKey
    def wordCount2(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val wordOne: RDD[(String, Int)] = words.map((_, 1))
        val groupBK: RDD[(String, Iterable[Int])] = wordOne.groupByKey()
        val wordCount = groupBK.mapValues(itor => itor.toList.sum)
        wordCount.collect().foreach(println)
    }

    // reduceByKey
    def wordCount3(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val wordOne: RDD[(String, Int)] = words.map((_, 1))
        val wordCount = wordOne.reduceByKey(_ + _)
        wordCount.collect().foreach(println)
    }
    // aggregateByKey
    def wordCount4(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val wordOne: RDD[(String, Int)] = words.map((_, 1))
        val wordCount = wordOne.aggregateByKey(0)(_+_,_+_)
        wordCount.collect().foreach(println)
    }

    // foldByKey
    def wordCount5(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val wordOne: RDD[(String, Int)] = words.map((_, 1))
        val wordCount = wordOne.foldByKey(0)(_+_)
        wordCount.collect().foreach(println)
    }

    // combineByKey
    def wordCount6(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val wordOne: RDD[(String, Int)] = words.map((_, 1))
        val wordCount = wordOne.combineByKey(
            v=>v,
            (x:Int,y)=>x+y,
            (x:Int,y:Int)=>x+y,
        )
        wordCount.collect().foreach(println)
    }

    // countByKey
    def wordCount7(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val wordOne: RDD[(String, Int)] = words.map((_, 1))
        val wordCount: collection.Map[String, Long] =wordOne.countByKey()
        wordCount.foreach(println)
    }

    // countByValue
    def wordCount8(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val stringToLong: collection.Map[String, Long] = words.countByValue()
        stringToLong.foreach(println)
    }

    // reduce
    def wordCount9(sc: SparkContext): Unit = {
        val rdd = sc.makeRDD(List("hello spark", "hello scala"))
        val words: RDD[String] = rdd.flatMap(_.split(" "))
        val mapWord: RDD[mutable.Map[String, Long]] = words.map(s => {
            mutable.Map[String, Long]((s, 1))
        })
        val wordCount = mapWord.reduce(
            (map1, map2) => {
                map2.foreach {
                    case (str, count) =>
                        val newCount = map1.getOrElse(str, 0L) + count
                        map1.update(str, newCount)
                }
                map1
            }
        )
        print(wordCount)
    }


}