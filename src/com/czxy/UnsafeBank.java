package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 19:53
 * @Description
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account, 50, "you");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");
        you.start();
        girlFriend.start();
    }
}

//账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行:模拟取款
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing ( Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    //取钱
    @Override
    public  void run() {
        //判断是否有钱
        synchronized (account){
            if (account.money-drawingMoney < 0 ){
                System.out.println(Thread.currentThread().getName()+"余额不足");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money =  account.money - drawingMoney;
            nowMoney = nowMoney+drawingMoney;
            System.out.println(account.name+"余额为："+account.money);
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }
    }
}
