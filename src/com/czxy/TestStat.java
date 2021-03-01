package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 17:57
 * @Description
 */

/**
 * 观察测试线程的状态
 */
public class TestStat   {
    public static void main(String[] args) {
       Thread thread = new Thread( ()->{
           for (int i = 0; i < 5; i++) {
               try {
                   Thread.sleep(1000);

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           System.out.println("/////////////");
       });

       //观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        //观察后再启动
        thread.start();
        state = thread.getState();
        System.out.println(state);

        //只要线程不停止，一直打印状态
        while (state != Thread.State.TERMINATED){
            try {
                Thread.sleep(100);
                //更新线程
                state = thread.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
