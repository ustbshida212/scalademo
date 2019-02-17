package com.itheima.day03

class Man(val name:String)
class SuperMan {
  def heat=print("超人打怪兽")
}

object SuperMan {
  //隐式转换方法,因为在当前object中定义,就不用导入了
  implicit def man2SuperMan(man:Man)=new SuperMan
  def main(args: Array[String]) {
    val hero = new Man("hero")
    //Man具备了SuperMan的方法
    hero.heat
  }
}
