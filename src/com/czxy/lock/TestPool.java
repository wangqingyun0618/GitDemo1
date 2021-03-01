package com.czxy.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author {王庆运}
 * @Date: 2020/11/29/ 18:05
 * @Description
 */
public class TestPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        service.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
