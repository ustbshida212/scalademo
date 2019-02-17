package com.itheima.scala

class ScalaDemo1 {
  //val是不可变,相当于java中用final修饰的变量,只有get方法,没有set方法
  val name = "zhangsan";
  //既有get方法,又有set方法
  var age = 30;
  //可以在当前类中访问和伴生对象中访问
  private val address = "beijing";
  //权限比private修饰变量更加严格,只可以在当前类中访问
  private[this] val animal = "cat";

  def getName(): String = {
    name
  }

}

//main方法必须要写在object中
//object和class名字一样,就互为伴生关系
//class 为伴生类
//pbject为伴生对象
object ScalaDemo1 {
  def main(args: Array[String]): Unit = {
    val demo = new ScalaDemo1
    println(demo.name)
    demo.age = 45;
    println(demo.age)
    println(demo.address)
    println(demo.getName())
  }
}