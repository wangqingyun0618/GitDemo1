package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 16:17
 * @Description
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("线程vip.."+i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i <= 1000; i++) {
            if ( i == 200 ){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main ..."+i);
        }
    }
}
