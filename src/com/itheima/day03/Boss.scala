package com.itheima.day03

object Company{
  //在object中定义隐式值    注意：同一类型的隐式值只允许出现一次，否则会报错
  implicit  val aaa="zhangsan"
  implicit  val bbb=10000.00
//  implicit val ccc = "lisi"
}
class Boss {
  //注意参数匹配的类型   它需要的是String类型的隐式值
  def callName()(implicit name:String):String={
    name+" is coming !"
  }
  //定义一个用implicit修饰的参数
  //注意参数匹配的类型    它需要的是Double类型的隐式值
  def getMoney()(implicit money:Double):String={
    " 当月薪水："+money
  }
}
object Boss extends App{
  //使用import导入定义好的隐式值，注意：必须先加载否则会报错
  import Company._
  val boss =new Boss
  println(boss.callName()+boss.getMoney())

}

