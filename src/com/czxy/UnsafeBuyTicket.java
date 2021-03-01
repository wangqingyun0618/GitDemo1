package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 19:41
 * @Description
 */

/**
 * 不安全的买票
 * 有负数
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"a").start();
        new Thread(buyTicket,"b").start();
        new Thread(buyTicket,"c").start();
    }
}

class BuyTicket implements Runnable{
    private int tickNums = 10;
    boolean flag = true;
    @Override
    public void run() {
        //买票

        while (flag){
            buy();
        }
    }
    public synchronized void buy(){
        //判读是否有票
        if ( tickNums <= 0 ){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"拿到了："+tickNums--);
    }
}
