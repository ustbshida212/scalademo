package com.itheima.scala

import scala.util.Random


object CaseDemo01 extends App{
  val array = Array("hadoop","storm","spark",1,20.1,CaseDemo01);
  val name = array(Random.nextInt(array.length));

  name match{
    case "hadoop" => println("hadoop")
    case "storm" => println("storm")
    case x:Int => println(x);
    case y:Double if(y>0) => println(y)
    case z:String => println(z);
    case _ => println("other")
  }

}
