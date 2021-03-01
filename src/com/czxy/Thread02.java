package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/19/ 22:36
 * @Description
 */
public class Thread02 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println("实现Runnable接口的多线程");
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        Thread02 t2 = new Thread02( );
        //创建线程对象，通过线程对象来开启多线程
        new Thread(t2).start();
        for (int i = 0; i <800 ; i++) {
            System.out.println("多线程"+i);
        }
    }
}
