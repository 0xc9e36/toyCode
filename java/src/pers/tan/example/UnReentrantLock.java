package pers.tan.example;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnReentrantLock {

    public static void main(String[] args) {
        //不可重入锁
        Tlock tlock = new Tlock();

        //可重入锁
        //Lock tlock = new ReentrantLock();
        tlock.lock();
        System.out.println("第一次加锁");
        tlock.lock();
        System.out.println("第二次加锁");

        tlock.unlock();
        System.out.println("释放锁");
    }

}


class Tlock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        for (;;) {
            if (atomicReference.compareAndSet(null, thread)) {
                return ;
            }
        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
    }
}