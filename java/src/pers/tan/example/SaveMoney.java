package pers.tan.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaveMoney {

    public static void main(String[] args) {

        System.out.println("cpu核心数:" + Runtime.getRuntime().availableProcessors());
        System.exit(0);

        Bank bank = new Bank(100, 1000);
        for (int i = 0; i < 100; ++i) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int)(100*Math.random());
                        int amount = (int)(1000 * Math.random());
                        bank.add(fromAccount, toAccount, amount);
                        Thread.sleep((int)(10 * Math.random()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Bank {

    private final int[] accounts;
    private Lock lock = new ReentrantLock();
    private Condition condition;

    public Bank(int count, int initValue) {
        accounts = new int[count];
        Arrays.fill(accounts, initValue);
        condition = lock.newCondition();
    }

    //存钱
    public void add(int from, int to, int amount) {
        lock.lock();
        try {
            while (accounts[from] < amount) {
                condition.await();
            }
            //System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            //System.out.print(from + "  扣掉了" + amount);
            accounts[to] += amount;
            condition.signalAll();
            System.out.println("   总金额:" + get());
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public int get() {
        lock.lock();
        try {
            int sum = 0;
            for (int i : accounts) {
                sum += i;
            }
            return sum;
        }  finally {
            lock.unlock();
        }
    }
}

