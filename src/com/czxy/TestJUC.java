package com.czxy;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 20:29
 * @Description
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> onWriteArrayList = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread( ()-> {
                onWriteArrayList.add(Thread.currentThread().getName());
            } ).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(onWriteArrayList.size());
    }
}
