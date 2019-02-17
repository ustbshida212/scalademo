package com.itheima.scala

abstract class Person10 (val name:String){
  //抽象fields
  val age:Int
}
class Student10(name: String) extends Person10(name) {
  val age: Int = 50
}
