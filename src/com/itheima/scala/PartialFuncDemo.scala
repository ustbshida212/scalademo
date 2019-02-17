package com.itheima.scala

object PartialFuncDemo {

  val func1: PartialFunction[String, Int] = {
    case "one" => 1;
    case "two" => 2;
      //已经约束了输入是String 输出是Int,否则会报错
//    case 100 => "itcast"
    case _ => -1;
  }

  def func2(num:String) :Int = num match {
    case "one" => 1;
    case "two" => 2;
    case _ => -1;
  }
  def main(args: Array[String]): Unit = {
    println(func1("one"))
    println(func2("two"))
  }
}
