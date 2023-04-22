package com.ThreadPool;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        for(int i=0 ;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"输出了"+i);

        }
        try {
            System.out.println(Thread.currentThread().getName()+"睡眠");
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
