package com.itheima.scala

object HelloScala {
  //Unit 表示没有返回值,相当于java的void
  def main(args:Array[String]):Unit={

    println("hello scala");

    val list = List(1,2,3,4);
    list.reduceRight(_+_);
  }
}
