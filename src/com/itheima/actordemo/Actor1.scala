package com.itheima.actordemo

import scala.actors.Actor

/**
  * 1、定义一个class或者是object继承Actor特质，注意导包import scala.actors.Actor
  * 2、重写对应的act方法
  * 3、调用Actor的start方法执行Actor
  * 4、当act方法执行完成，整个程序运行结束
  */

class Actor1 extends Actor{
  override def act(): Unit = {
    for(i<- 1 to 10){
      println("Actor1---------"+i);
    }
  }
}

object Actor2 extends Actor{
  override def act(): Unit = {
    for( i <- 1 to 10){
      println("Actor2----------"+i);
    }
  }
}

object Actor1{
  def main(args: Array[String]): Unit = {
    //1.拿到Actor1的实例
    val actor = new Actor1()
    //2.调用对象的start方法
    actor.start();
    Actor2.start();
  }
}
