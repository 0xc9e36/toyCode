package pers.tan.example;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        //可重入锁
        Rlock tlock = new Rlock();

        //不可重入锁
        //Tlock tlock = new Tlock();
        tlock.lock();
        System.out.println("第一次加锁");
        tlock.unlock();
        System.out.println("释放了锁");

        //System.out.println(tlock.thread().getName());

    }
}



class Rlock {
    private int count = 0;
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public Thread thread() {
        return atomicReference.get();
    }

    public void lock() {
        Thread thread = Thread.currentThread();
        if (thread == atomicReference.get()) {
            count++;
            return;
        }

        for (;;) {
            if (atomicReference.compareAndSet(null, thread)) {
                return ;
            }
        }

    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        if (thread == atomicReference.get()) {
            if (count != 0) {
                count--;
            } else {
                atomicReference.compareAndSet(thread, null);
            }
        }
    }

}