package com.czxy;

/**
 * @Author {王庆运}
 * @Date: 2020/11/28/ 15:00
 * @Description
 */
public class Deom01 { //实现类

    public static void main(String[] args) {
        iLike iLike = null;
         iLike = ()-> {
            System.out.println("i like lamda");
        };
        iLike.lamda();
        Runnable runnable = null;
        runnable = ()-> {
            System.out.println("1111");
        };
        new Thread(()-> System.out.println("11")).start();
    }

}
//定义一个函数式接口
interface iLike {
    void lamda();
}
