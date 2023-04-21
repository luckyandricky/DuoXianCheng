package com.Thread1;

/**
 * 两种方式开多线程
 * 1. 继承Thread类，因为Thread类实现了Runnable接口
 * 2. 实现Runnable接口: 定义一个任务类实现Runnable接口，实现Runnable中的run方法
 * 3. (Callable接口):前两种方式都存在一个问题
 *      - 他们重写的run方法不能直接返回结果
 *      - 不适合需要返回线程结果的业务场景
 */

public class Demo1 {
    public static void main(String[] args) {
        Thread m = new MyThread();
        m.setName("1号");
        System.out.println(m.getName());
        m.start();

        Runnable target2 = new MyThread2();
        Thread t = new Thread(target2);
        t.setName("子线程2");
        t.start();

        Thread m3 = new MyThread();
        m3.setName("3号");
        m3.start();

        Thread ct = Thread.currentThread();
        System.out.println(ct.getName());
        for (int i=0;i<5;i++){
            System.out.println("主线程输出"+i);
            if (i==3){
                try {
                    //休眠3秒
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
