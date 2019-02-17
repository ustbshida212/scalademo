package com.itheima.scala

import scala.util.Random

//class是多例,后面必须跟构造参数
case class SubmitClass(id:String,name:String)
case class HeartBeat(time:Long)

//object是单例,后面不能跟构造参数
case object CheckTimeOutTask

object CaseDemo04 extends App{

  val arr = Array(CheckTimeOutTask,HeartBeat(20),SubmitClass("2","hello"));
  arr(Random.nextInt(arr.length)) match {
    case CheckTimeOutTask => println("CheckTimeOutTask")
    case HeartBeat(id) => println("HeartBeat")
    case SubmitClass(id,name) => println("SubmitClass")
  }


}