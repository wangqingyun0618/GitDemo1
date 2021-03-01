package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 15:53
 * @Description
 */

import java.util.Date;

/**
 * 测试礼让线程
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
        new Thread(myYield,"c").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}
