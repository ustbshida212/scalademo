package com.itheima.scala

class MainDemo {
}

//main方法写在object方法中
object MainDemo{
  def main(args: Array[String]): Unit = {
    println("maindemo1")
  }
}
//如果不想写main方法,需要继承App类
object MainDemo2 extends App{
  println("mainDemo2")
}