package pers.tan.lock;


import java.util.ArrayList;
import java.util.List;

public class DeadLockTest {

    static class OOMObj {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void main(String[] args) throws Exception {
//        Thread t1 = new ThreadA();
//        Thread t2 = new ThreadB();
//        t1.start();
//        t2.start();

        //fillHeap(1000);
    }

    public static void fillHeap(int num) throws Exception {
        List<OOMObj> list = new ArrayList<>();
        for(int i = 0; i < num; ++i) {
            Thread.sleep(50);
            list.add(new OOMObj());
        }
        System.gc();
        System.out.print("gc完啦");
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        synchronized (Object.class) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Integer.class) {
            }
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        synchronized (Integer.class) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Object.class) {

            }
        }
    }
}