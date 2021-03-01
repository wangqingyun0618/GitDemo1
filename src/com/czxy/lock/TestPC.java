package com.czxy.lock;

/**
 * @Author {王庆运}
 * @Date: 2020/11/29/ 17:11
 * @Description
 */

/**
 * 测试生产者消费者模型
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}
//生产者
class Productor extends Thread{
   SynContainer container;
   public Productor (SynContainer container){
       this.container = container;
   }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer (SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{

    int id; //产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
   Chicken[] chickens = new Chicken[10];
   int count = 0;

   //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果生产满了，需要等待消费者消费
        if (count == chickens.length){
            try {
                //生产等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count++;
        // 可以通知消费者消费了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        if (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}
