package com.itheima.scala

/**
  * 	在 trait 中，可以混合使用具体方法和抽象方法；
    	可以让具体方法依赖于抽象方法，而抽象方法则可放到继承 trait的子类中去实现；
  */

trait ValidTrait {
  //抽象方法
  def getName: String
  //具体方法，具体方法的返回值依赖于抽象方法
  def valid: Boolean = {
    "Tom".equals(this.getName)
  }
}
class PersonForValid(val name: String) extends ValidTrait {
  def getName: String = this.name
}

object PersonForValid{
  def main(args: Array[String]): Unit = {
    val person = new PersonForValid("Rose")
    println(person.valid)
  }
}
