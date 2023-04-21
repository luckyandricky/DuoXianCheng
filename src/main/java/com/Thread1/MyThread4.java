package com.Thread1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyThread4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> call = new MyThreadCall(10);
        FutureTask<String> ft = new FutureTask<>(call);
        Thread t = new Thread(ft);
        t.start();

        //如果ft没有跑完，这里的get会等待，直到线程跑完提取结果
        System.out.println(ft.get());


    }


}

/**
 * 定义一个任务类，实现Callable接口，应该声明线程任务执行完毕后结果的数据类型
 */

class MyThreadCall implements Callable<String>{
    private int n;
    public MyThreadCall(int n){this.n = n;}

    @Override
    public String call() throws Exception{
        int sum =0;
        for (int i=0;i<5;i++){
            sum += i;
        }
        return "返回"+sum;
    }
}