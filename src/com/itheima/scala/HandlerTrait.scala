package com.itheima.scala

trait HandlerTrait {
  def handle(data: String) = {println("last one")}
}
trait DataValidHandlerTrait extends HandlerTrait {
  override def handle(data: String) = {
    println("check data: " + data)
//    super.handle(data)
  }
}
trait SignatureValidHandlerTrait extends HandlerTrait {
  override def handle(data: String) = {
    println("check signature: " + data)
    super.handle(data)
  }
}
class PersonForRespLine(val name: String) extends SignatureValidHandlerTrait with DataValidHandlerTrait {
  def sayHello = {
    println("Hello, " + this.name)
    this.handle(this.name)
  }
}
//PersonForRespLine类中继承的trait都有sayHello方法,每个方法都有super方法
//调用时从最右边的trait的hadle方法开始执行
object PersonForRespLine{
  def main(args: Array[String]) {
    val p=new PersonForRespLine("tom")
    p.sayHello
    //执行结果：
    //    Hello, tom
    //    check data: tom
    //    check signature: tom
    //    last one
  }
}

