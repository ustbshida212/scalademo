package com.itheima.scala

class Person6{
  protected val name:String="tom"
  protected[this] val hobby:String ="game"
  protected def sayBye=println("再见...")
}
class Student6 extends Person6{
  //父类使用protected 关键字来修饰 field可以直接访问
  def  sayHello =println("Hello "+name)
  //父类使用protected 关键字来修饰method可以直接访问
  def  sayByeBye=sayBye
  //父类中庸protected[this]修饰的,只允许在当前子类中访问
  def makeFriends(s:Student6)={
    println("My hobby is "+hobby+", your hobby is UnKnown")
  }
}
object Student6{
  def main(args: Array[String]) {
    val s:Student6=new Student6 //Student6的子类对象
    s.sayHello
    s.sayByeBye
    s.makeFriends(s)
    s.name
    //s.hobby 不能访问父类中protected[this] 定义的变量, 这个就是子类对象,想访问只能在子类中调用

    //当前类对象中无法访问protected[this]修饰的方法和变量,下面这句代码报错
    val p:Person6 = new Person6
    //p.hobby

  }
}
object Hello6{
  def main(args: Array[String]): Unit = {
    val p = new Person6
  }
}