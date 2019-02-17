package com.itheima.scala;

public interface Hello {


    public default String sayHello(){
        System.out.println("hello");
        return "hello";
    }
}

class Demo implements Hello{
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.sayHello();
    }
}