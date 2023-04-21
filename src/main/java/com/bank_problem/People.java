package com.bank_problem;

public class People extends Thread{
    private Account acc;

    public People(Account acc,String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(10000.0);
    }
}
