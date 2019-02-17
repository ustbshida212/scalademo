package com.itheima.scala

trait HelloTrait {
  def sayHello(): Unit
}
trait MakeFriendsTrait {
  def makeFriends(c: Children): Unit
}
//多重继承 trait,使用with关键字
class Children(val name: String) extends HelloTrait with MakeFriendsTrait with Cloneable with Serializable{
  def sayHello() =println("Hello, " + this.name)
  def makeFriends(c: Children) = println("Hello, my name is " + this.name + ", your name is " + c.name)
}
object Children{
  def main(args: Array[String]) {
    val c1=new Children("tom")
    val c2=new Children("jim")
    c1.sayHello()//Hello, tom
    c1.makeFriends(c2)//Hello, my name is tom, your name is jim
  }
}

