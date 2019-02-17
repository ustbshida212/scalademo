package com.itheima.actordemo

import scala.actors.Actor

/**
  * 使用react方法代替receive方法去接受消息
    好处：react方式会复用线程，避免频繁的线程创建、销毁和切换。比receive更高效
    注意: react 如果要反复执行消息处理，react外层要用loop，不能用while
  */
class Actor5 extends Actor{
  override def act(): Unit = {
    loop{
      react{
        case "start" =>println("Starting....");
        case "stop" => println("Stoping...");
      }
    }
  }
}

object Actor5{
  def main(args: Array[String]): Unit = {
    val actor = new Actor5()
    actor.start();

    actor ! "start";
    actor ! "stop";
  }
}
