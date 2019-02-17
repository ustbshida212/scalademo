package com.itheima.scala
class Super
class Sub extends Super
//协变
class Temp1[+A](title: String)
//逆变
class Temp2[-A](title: String)
//非变
class Temp3[A](title: String)


object Covariance_demo {

  def main(args: Array[String]): Unit = {

    //父类引用指向子类对象
    //协变: Temp1[Sub]还是Temp1[Super]的子类
    val t1:Temp1[Super] = new Temp1[Sub]("hello scala")

    //逆变:Temp2[Super]是Temp2[Sub]子类对象
    val t2:Temp2[Sub] = new Temp2[Super]("hello scala")
    //非变:Temp3[Super]和Temp3[Sub]没有关系,以下代码报错
//    val t3:Temp3[Super] = new Temp3[Sub]("hello scala")
//    val t3:Temp3[Sub] = new Temp3[Super]("hello scala")
  }
}
