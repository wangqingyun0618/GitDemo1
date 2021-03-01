package com.czxy.lock;

/**
 * @Author {王庆运}
 * @Date: 2020/11/29/ 15:26
 * @Description
 */

/**
 * 测试死锁
 */
public class TestLock  {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "小红");
        Makeup g2 = new Makeup(1, "小云");
        g1.start();
        g2.start();
    }
}

class Lipstick {

}
class Mirror{

}

class Makeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice;
    String girlname;
    Makeup (int choice,String girlname){
        this.choice = choice;
        this.girlname = girlname;
    }
    @Override
    public void run (){
        makeup();
    }

    private void makeup () {
        if (choice==0){
            synchronized (lipstick){
                System.out.println(this.girlname+"拿到了口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girlname+"拿到了镜子");
                }
            }

        }else {
            synchronized (mirror){
                System.out.println(this.girlname+"拿到了镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(this.girlname+"拿到了口红");
                }
            }
        }
    }

}