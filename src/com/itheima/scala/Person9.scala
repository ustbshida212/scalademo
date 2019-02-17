package com.itheima.scala

abstract class Person9(val name:String) {
  //必须指出返回类型，不然默认返回为Unit
  def sayHello:String
  def sayBye:String

  val age:Int
}
class Student9(name:String) extends Person9(name){
  //必须指出返回类型，不然默认
  //override关键字可加可不加
  override def sayHello: String = "Hello,"+name
  def sayBye: String ="Bye,"+name
  override val age = 50;
}
object Student9{
  def main(args: Array[String]) {
    val s = new Student9("tom")
    println(s.sayHello)
    println(s.sayBye)
  }
}
