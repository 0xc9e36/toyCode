package pers.tan.lock;

import java.util.concurrent.locks.*;

public class LockTest {
    public static void main(String[] args) {

        Deport deport = new Deport(100);

        Producter p1 = new Producter(deport);
        Consumer c1 = new Consumer(deport);
        p1.exec(60);
        p1.exec(120);
        c1.exec(150);
        c1.exec(90);
        p1.exec(110);

        Lock lock = new ReentrantLock();
    }
}


class Deport {

    private int capacity;    // 仓库的容量
    private int size;
    private Lock lock;
    private Condition fullCondtion;       // 生产条件
    private Condition emptyCondtion;      // 消费条件

    public Deport(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.fullCondtion = lock.newCondition();
        this.emptyCondtion = lock.newCondition();
    }


    public void producter(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size >= capacity) {
                    fullCondtion.await();
                }
                int count = (size + left) >= capacity ? (capacity - size) : left;
                left -= count;
                size += count;
                System.out.println("本次生产" + count + "件产品，容量为" + size);
                emptyCondtion.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size <= 0) {
                    emptyCondtion.await();
                }
                int count = size >= left ? left : size;
                left -= count;
                size -= count;
                System.out.println("本次消费了" + val + "个产品,当前容量" + size);
                fullCondtion.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class Producter {
    private Deport deport;
    public Producter(Deport deport) {
        this.deport = deport;
    }
    public void exec(int num) {
        new Thread() {
            @Override
            public void run() {
                deport.producter(num);
            }
        }.start();
    }
}

class Consumer {
    private Deport deport;
    public Consumer(Deport deport) {
        this.deport = deport;
    }
    public void exec(int num) {
        new Thread() {
            @Override
            public void run() {
                deport.consumer(num);
            }
        }.start();
    }
}