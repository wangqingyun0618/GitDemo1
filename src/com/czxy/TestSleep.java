package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 15:37
 * @Description
 */
public class TestSleep implements Runnable {
    //票数
    private int tickNums = 10;
    @Override
    public void run() {
        while (true){
            if (tickNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName()+"-->抢到了第"+tickNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep test02Thread = new TestSleep();

        new Thread(test02Thread,"小明").start();
        new Thread(test02Thread,"老师").start();
        new Thread(test02Thread,"黄牛").start();
    }
}
