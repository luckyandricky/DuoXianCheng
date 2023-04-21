package com.Thread1;

public class MyThread extends Thread{
    public MyThread(){

    }
    public MyThread(String name){super(name);}

    //重写run方法
    @Override
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
