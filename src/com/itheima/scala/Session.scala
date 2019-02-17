package com.itheima.scala

class Session {
}

object SessionFactory {
//相当于java的静态块
  val session = new Session();
//object中定义的方法相当于java的静态方法
  def getSession(): Session = {
    session;
  }
}

object SingletonDemo {
  def main(args: Array[String]): Unit = {

    //SessionFactory是单例对象,不需要new,用单例对象.方法直接调用对象中的方法和变量
    val session1 = SessionFactory.session;
    val session2 = SessionFactory.getSession()
    println(session1 == session2);
  }
}
