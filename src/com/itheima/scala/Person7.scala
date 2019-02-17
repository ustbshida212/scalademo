package com.itheima.scala

class Person7(val name:String,val age:Int){ //new Person7("zhangsan",50)
  var score :Double=0.0
  var address:String="beijing"

  println("Person7父类的主构造器执行")
  def this(name:String,score:Double)={ //new Person7("zhangsan",50.0)
    //每个辅助constructor的第一行都必须调用其他辅助constructor或者主constructor代码
    //主constructor代码
    this(name,30)
    this.score=score
  }
  //其他辅助constructor
  def this(name:String,address:String)={
    this(name,100.0)
    this.address=address
  }
}

/**
  * 1.Scala中，每个类都可以有一个主constructor和任意多个辅助constructor，
  * 而且每个辅助constructor的第一行都必须调用其他辅助constructor或者主constructor代码；
  * 因此子类的辅助constructor是一定不可能直接调用父类的constructor的；
  * 因为子类辅助构造器必须先调用自己的主构造器,或者自己的其他辅构造器
  *
  * 2.只能在子类的主constructor中调用父类的constructor。
  *
  * 3.如果父类的构造函数已经定义过的 field，比如name和age，子类再使用时，就不要用 val 或 var 来修饰了，
  * 否则会被认为，子类要覆盖父类的field，且要求一定要使用 override 关键字。
  * @param name
  * @param score
  */
  //用子类的主构造器来调用父类的构造器
class Student7(name:String,score:Double) extends Person7(name,score){
  //子类自己的辅构造器
  def this(name:String){
    this(name,100.0);
  }
}

object ABC{
  def main(args: Array[String]): Unit = {
    new Student7("李四",100.0)
  }
}
