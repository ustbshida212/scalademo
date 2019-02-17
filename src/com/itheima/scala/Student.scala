package com.itheima.scala

//类名后的括号为主构造器
class Student(val name: String, var age: Int) { //new Student("zhangsan",10)
  println("执行主构造器");

  private var gender = "male";

  //this表示辅构造器
  def this(name: String, age: Int, gender: String) {
    //当前每个辅助构造器必须以主构造器或者其他辅助构造器调用开始
    this(name, age);
    this.gender = gender;
  }

  def this(name: String) {
    this(name, 30);
  }
}

object Student {
  def main(args: Array[String]): Unit = {
    val zhangsan = new Student("zhangsan");
    println(zhangsan.gender);

    val lisi = new Student("lisi", 20);
    println(lisi.age);
  }
}
