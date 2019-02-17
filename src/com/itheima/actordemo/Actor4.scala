package com.itheima.actordemo

import scala.actors.Actor

/**
  * 实现actor不断发送和接收消息,通过在receive方法外面加while循环实现
  */
class Actor4 extends Actor{
  override def act(): Unit ={
    //接收消息
    while(true){
      receive{
        case "helloworld" => println("hello world!");
        case "start" => println("start!");
      }
    }
  }
}

object Actor4 {
  def main(args: Array[String]): Unit = {
    val actor4 = new Actor4()
    actor4.start();

    //向actor发送数据
    //! 发送异步消息,没有返回值
    actor4 ! "helloworld";

    actor4 ! "start";
  }
}