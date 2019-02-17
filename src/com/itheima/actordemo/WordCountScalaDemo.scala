package com.itheima.actordemo

import scala.actors.{Actor, Future}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * 大致的思想步骤：
  * 1、通过loop +react 方式去不断的接受消息
  * 2、利用case class样例类去匹配对应的操作
  * 3、其中scala中提供了文件读取的接口Source,通过调用其fromFile方法去获取文件内容
  * 4、将每个文件的单词数量进行局部汇总，存放在一个ListBuffer中
  * 5、最后将ListBuffer中的结果进行全局汇总。
  */
case class SubmitClass(filePath: String)

case class ResultClass(result:Map[String, Int])

class WordCountScalaDemo extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case SubmitClass(filePath) => {
          //读取文件数据
          val data = Source.fromFile(filePath).mkString
          //按照换行符切分
          // windows换行符:\r\n
          // linux换行符 \n
          //mac换行符 \r
          val by: Map[String, Array[(String, Int)]] = data.split("\r\n").flatMap(_.split(" ")).map((_, 1)).groupBy(_._1);

          /**
            * hadoop---ArrayBuffer((hadoop,1))
            * world---ArrayBuffer((world,1))
            * hello---ArrayBuffer((hello,1), (hello,1))
            */
          val result: Map[String, Int] = by.mapValues(_.length)
          sender ! ResultClass(result);
        }
      }
    }
  }
}

object WordCountDemo {
  def main(args: Array[String]): Unit = {
    //定义一个set集合,用于保存每一个文件产生的Future
    val futureSet = mutable.HashSet[Future[Any]]();
    //顶一个一个list集合.用于保存每一个Future真实数据
    val resultList = new ListBuffer[ResultClass]();
    //准备数据文件

    val files = Array("E:/aa.txt", "E:/bb.txt", "E:/cc.txt");
    for (f <- files) {
      //1.创建Actor
      val demo = new WordCountScalaDemo();
      demo.start();
      //2.向Actor发送消息
      val reply: Future[Any] = demo !! SubmitClass(f)
      futureSet.add(reply);
    }

    //循环的是从这开始循环,可能集合里还没有返回值，所以需要过滤
    while (futureSet.size > 0) {
      //过滤出已经有数据的set
      val filter: mutable.HashSet[Future[Any]] = futureSet.filter(_.isSet)
      for (c <- filter) {
        //获取Future中的数据
        val apply = c.apply()
        resultList += apply.asInstanceOf[ResultClass];
        //从futureset中移除掉把数据添加到list中Future
        futureSet -= c;
      }
    }
    println(resultList.map(_.result).flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2)))
  }
}
