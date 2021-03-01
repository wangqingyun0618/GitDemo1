package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/19/ 22:35
 * @Description
 */
public class Thread01 extends Thread {
    public static void main(String[] args) {
        //创建一个线程对象开启多线程
        Thread01 thread01 = new Thread01();
        thread01.start();
    }
      @Override
      public void run () {
          for (int i = 0; i <5 ; i++) {
              System.out.println("这是一个多线程");
          }
      }
}
