package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 15:25
 * @Description
 */
public class Test01 implements Runnable {
    //设置一个标志位
    boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run ......"+ i++);
        }
    }
    //设置一个公开方法停止线程，装换标志位
    public void  stop () {
        this.flag = false;
    }
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        new Thread(test01).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main "+ i);
             if (i == 900) {
                 test01.stop();
                 System.out.println("线程终止");
             }
        }
    }
}
