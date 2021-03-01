package com.czxy.lock;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author {王庆运}
 * @Date: 2020/11/29/ 15:51
 * @Description
 */
public class TestLock2 {
    public static void main(String[] args) {
        Test t = new Test();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
class Test implements Runnable{
    int tickNums = 10;
    //定义锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (tickNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickNums--);
                }else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}