package com.itheima.scala

class Person1 {
  private val name = "leo"
  val age=50
  def getName = this.name
}
class Student1 extends Person1{
  private val score = "A"
  def getScore = this.score

  //子类可以覆盖父类的 val field,使用override关键字
  override val age=30

  //覆盖父类非抽象方法，必须要使用 override 关键字
  //同时调用父类的方法，使用super关键字
  override def getName = "your name is " + super.getName
}
object Student1 {
  def main(args: Array[String]): Unit = {
    val student = new Student1()
    println(student.getName);
  }
}