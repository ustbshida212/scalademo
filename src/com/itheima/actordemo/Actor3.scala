package com.itheima.actordemo

import scala.actors.Actor

/**
  * 怎么实现actor发送、接受消息
    *1、定义一个class或者是object继承Actor特质，注意导包import scala.actors.Actor
    *2、重写对应的act方法
    *3、调用Actor的start方法执行Actor
    *4、通过不同发送消息的方式对actor发送消息
    *5、act方法中通过receive方法接受消息并进行相应的处理
    *6、act方法执行完成之后，程序退出
  */

class Actor3 extends Actor{
  override def act(): Unit ={
    //接收消息
    receive{
      case "helloworld" => println("hello world!");
      case "start" => println("start!");
    }
  }
}

object Actor3 {
  def main(args: Array[String]): Unit = {
    val actor3 = new Actor3()
    actor3.start();

    //向actor发送数据
    //! 发送异步消息,没有返回值
    actor3 ! "helloworld";
    //这句接收不到,是因为actor已经执行完成退出
    actor3 ! "start";
  }
}