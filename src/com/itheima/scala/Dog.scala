package com.itheima.scala

class Dog {

  val id=1;
  private var name = "itcast";

  ////在Dog类中可以访问伴生对象Dog的私有属性
  def printName():Unit = {
    println(Dog.CONSTANT+name)
  }

}

object Dog{
  private val CONSTANT="HELLO";

  def main(args: Array[String]): Unit = {
    val dog = new Dog();
    dog.name="itcast"
    dog.printName()

    Array
  }
}
