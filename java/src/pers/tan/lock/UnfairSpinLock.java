package pers.tan.lock;

import java.util.concurrent.atomic.AtomicReference;


/*非公平自旋锁*/
public class UnfairSpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();

        // 只有owner没有被加锁的时候，才能够加锁成功，否则自旋等待
        while (!owner.compareAndSet(null, currentThread)) {

        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();

        // 只有锁的owner才能够释放锁，其它的线程因为无法满足Compare，因此不会Set成功
        owner.compareAndSet(currentThread, null);
    }
}
