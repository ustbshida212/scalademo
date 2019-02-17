package com.itheima.scala

object CaseDemo3 extends App{
  val arr = Array(1,3,5);
  arr match{
    case Array(1,x,y) => println(x+"---"+y)
    case Array(1,_*) => println("1....")
    case Array(1) => println("1")
  }
  val list = List(3,-1)
  //scala中列表要么为空,要么是一个head元素加上一个tail元素
  //9::List(5,2)表示给定一个head 9,给定一个tail 5,2 ,组成新的list(9,5,2)
  //9::5::2::Nil ,右结合,相当于9::(5::(2::Nil))
  list match{
    case 0::Nil => println("0")
    case x::y::Nil => println(s"x:$x,y:$y")
    case 0::tail => println("0....")
    case _ => println("other...")
  }
  val tuple = (1,2,3)
  tuple match {
//    case (1,x,y) => println(1,s"$x",s"$y")
    case (_,z,5) => println("_,_,5")
    case _ => println("else")
  }

}
