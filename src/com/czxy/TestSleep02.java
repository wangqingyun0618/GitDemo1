package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 15:40
 * @Description
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟倒计时
 */
public class TestSleep02  {
    public void  tenDown(){
        int num = 10;

        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(num--);
                if (num <= 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestSleep02 testSleep02 = new TestSleep02();
        testSleep02.tenDown();
        Date starTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(starTime));
                starTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
