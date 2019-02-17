package com.itheima.scala

class Person {
  val name = "zhangsan"
  //	private 修饰的 field 和 method 不可以被子类继承，只能在类的内部使用；
  private val age = 10;
  var sex = "男"
  def getName  = {
    this.name
  }
}
object test{
  private val person = new Person
  //person.age 报错
}


class student extends Person{
  //如果子类想要定义父类中以val定义的同名字段,必须要加上override关键字
  override val name ="lisi";
  //下面这句代码如果不加override会报错
  override def getName = this.name

  //父类的age 用private修饰,所以子类无法继承,所以可以在子类自己类中自己写一个同名的属性
  val age = 1001;
  //子类可以定义自己的属性和方法

  val score = "A"
  def getScore = this.score
   //	field 必须要被定义成 val 的形式才能被继承，并且还要使用 override 关键字。
  // 因为 var 修饰的 field 是可变的，在子类中可直接引用被赋值，不需要被继承；即 val
  //修饰的才允许被继承，var 修饰的只允许被引用。继承就是改变、覆盖的意思。
  sex = "famle"

}
