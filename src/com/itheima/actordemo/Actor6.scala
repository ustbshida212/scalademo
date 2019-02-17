package com.itheima.actordemo

import scala.actors.{Actor, Future}

//17:00 关于异步有返回值类型的Future

/**
  * 结合case class样例类发送消息和接受消息
  * 1、将消息封装在一个样例类中
  * 2、通过匹配不同的样例类去执行不同的操作
  * 3、Actor可以返回消息给发送方。通过sender方法向当前消息发送方返回消息
  */
//同步消息
case class SyncMessage(id:Int,msg:String)
//异步消息
case class AsyncMessage(id:Int,msg:String)
//返回的结果数据
case class ReplyMessage(id:Int,msg:String)

class Actor6 extends Actor{
  override def act(): Unit = {
    loop{
      receive{
        case "start" => println("Starting....");
        case SyncMessage(id,msg) =>{
//          println(s"id$id,SyncMessage:msg$msg")
//          Thread.sleep(2000);
          sender ! ReplyMessage(1,"Finished....");
        }
        case AsyncMessage(id,msg) =>{
//          println(s"id$id,AsyncMessage:msg$msg");
//          Thread.sleep(2000);
          sender ! ReplyMessage(3,"finished...");
        }
      }
    }

  }
}

object MainActor{
  def main(args: Array[String]): Unit = {
    val actor = new Actor6()
    actor.start();
    actor ! "start";
    //异步无返回值消息
    val reply0 = actor ! AsyncMessage(1, "异步消息,没有返回值")
    println("异步消息reply0的返回值是"+reply0);
    val reply1: Future[Any] = actor !! AsyncMessage(1, "异步消息,有返回值!")
    //异步消息,有返回值,返回值类型是Future[Any]
    println("异步消息reply1的返回值是"+reply1)
    //同步消息,有返回值
    val reply2 = actor !? SyncMessage(1, "同步消息,有返回值!")
    println("同步消息reply2的返回值是"+reply2);
  }
}
