package com.Thread1;

public class MyThread3 {
    //匿名内部类
    public static void main(String[] args){
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("子线程三: "+i);
                }
            }
        };
        Thread t = new Thread(target);
        t.start();

        Thread t2 = new Thread(
                () -> {
                    for (int i=0;i<50;i++){
                        System.out.println("子线程2: "+i);
                    }
                }
        );
        t2.start();

    }
}
