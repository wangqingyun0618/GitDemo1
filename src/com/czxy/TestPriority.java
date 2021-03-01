package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 18:48
 * @Description
 */

import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;

/**
 * 线程优先级
 */
public class TestPriority  {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        Mypriority mypriority = new Mypriority();
        Thread t1 = new Thread(mypriority);
        Thread t2 = new Thread(mypriority);
        Thread t3 = new Thread(mypriority);
        Thread t4 = new Thread(mypriority);
        Thread t5 = new Thread(mypriority);
        Thread t6 = new Thread(mypriority);

        //设置优先级
        t1.start();
        t2.setPriority(4);
        t2.start();
        t3.setPriority(7);
        t3.start();
        t4.setPriority(9);
        t4.start();
        t5.setPriority(1);
        t5.start();
        t6.setPriority(Thread.MAX_PRIORITY);//MAX_PRIORITY默认是10
        t6.start();

    }
}
class Mypriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
