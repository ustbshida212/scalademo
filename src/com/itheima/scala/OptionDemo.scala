package com.itheima.scala

/**
  * Option类型用样例类来表示可能存在或者可能不存在的值(Option的子类有Some和None)。Some包装了某个值，None表示没有值.
  */

object OptionDemo {
  def main(args: Array[String]): Unit = {
    val map = Map(("a",1),("b",2));
    val v: Option[Int] = map.get("a")
    //如果key不存在,直接取会报错
    //Some 和 None是两个样例类
     v  match{
      case Some(i) => println(i)
      case None =>println(0)
    }
  }
}
