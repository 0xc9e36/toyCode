package pers.tan.lock;

import java.util.concurrent.atomic.AtomicInteger;

/*公平自旋锁*/
public class FairSpinLock {

    private AtomicInteger serviceNo = new AtomicInteger(0);

    private AtomicInteger needNo = new AtomicInteger(0);

    public int lock() {
        int acquiredNo = needNo.getAndIncrement();
        while (acquiredNo != serviceNo.get()) {
            //自旋

        }
        return acquiredNo;
    }

    public void unlock(int no) {
        //服务号增加
        int nextNo = serviceNo.get()+ 1;
        serviceNo.compareAndSet(no, nextNo);
    }
}
