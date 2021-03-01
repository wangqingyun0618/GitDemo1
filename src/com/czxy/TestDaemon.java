package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 19:20
 * @Description
 */

/**
 * 测试守护线程
 */
public class TestDaemon {
    public static void main(String[] args) {
        We we = new We();
        You you = new You();
        Thread thread = new Thread(we);
        thread.setDaemon(true);
        thread.start();

        new Thread(you).start();
    }
}
//我
class We implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("我守护着你");
        }
    }
}

//你
 class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36600; i++) {
            System.out.println("你一生都在开心的活着");
        }
        System.out.println("goodbye world");
    }
}
