package com.ThreadPool;

import java.util.concurrent.*;

public class demo1 {
    public static void main(String[] args) {
        /**
         * 参数一：指定线程池数量
         * 参数二：指定线程池可支持的最大存货时间
         * 参数三：指定临时线程的最大存活时间
         * 参数四：指定存活时间的单位
         * 参数五：指定任务队列 不能为null
         * 参数六：指定用哪个线程工厂创建线程 ThreadFactory
         * 参数七：指定线程忙，任务满的时候，新任务来了怎么办 handel
         */
        ExecutorService pool = new ThreadPoolExecutor(3,5,6,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //给任务线程池处理
        Runnable target = new MyRunnable();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        //开始创建临时线程
        pool.execute(target);
        pool.execute(target);

    }
}
