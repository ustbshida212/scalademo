package com.itheima.day03

import java.io.File

import scala.io.Source

//案例1:让File类具备RichFile的read方法
object MyPredef{
  implicit def file2RichFile(f:File) = new RichFile(f)
}

class RichFile(val file:File){
  def read():String=Source.fromFile(file).mkString
  //
}
object RichFile{
  def main(args: Array[String]): Unit = {
    //1.创建File对象
    val file = new File("d:/test.txt")
    //隐式转换定义不在当前object中,需要手动导入隐式转换
    import MyPredef.file2RichFile
    val read: String = file.read()
    println(read)
  }
}
