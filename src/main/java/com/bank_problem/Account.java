package com.bank_problem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String CarId;
    private Double Money;

    //fina修饰后，唯一且不可变
    private final Lock lock = new ReentrantLock(); //悲观锁
    //Java 中的synchron 和 ReentrantLock
    public Account(String carId, Double money){
        CarId = carId;
        Money = money;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public Double getMoney() {
        return Money;
    }

    public void setMoney(Double money) {
        Money = money;
    }

    public void drawMoney(double v){
        String name = Thread.currentThread().getName();
        //同步代码块

        lock.lock();
        try {
            if(this.Money >=v){
                System.out.println(name + "来取钱"+Money);
                this.Money -= v;
                System.out.println(name + "取钱后的余额"+this.Money);
            }else{
                System.out.println(name+"来取钱余额不足");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();//解锁
        }
    }

    //同步代码块上锁
    public void drawMoney2(double v) {
        String name = Thread.currentThread().getName();
        //同步代码块
        //- 建议使用共享资源作为锁对象
        //- 对于实例方法建议使用this作为锁对象
        //- 对于静态方法，建议使用字节码(类名.calss) 对象作为锁对象
        synchronized (this) {
            try {
                if (this.Money >= v) {
                    System.out.println(name + "来取钱" + Money);
                    this.Money -= v;
                    System.out.println(name + "取钱后的余额" + this.Money);
                } else {
                    System.out.println(name + "来取钱余额不足");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //synchronized 同步方法
    public synchronized void drawMoney3(double money) {
        try {
            String name = Thread.currentThread().getName();
            if(this.Money >=money){
                this.Money -= money;
                System.out.println(name+"来取钱"+money+"成功");
                this.notifyAll();//唤醒所有线程
                this.wait();//锁对象，让当前线程进入等待

            }else {
                this.notifyAll();//唤醒所有线程
                this.wait();//锁对象，让当前线程进入等待

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
