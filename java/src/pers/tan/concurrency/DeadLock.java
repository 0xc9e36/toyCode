package pers.tan.concurrency;

public class DeadLock {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Integer.class) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Double.class) {
                    }
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Double.class) {
                    synchronized (Integer.class) {

                    }
                }
            }
        }, "B").start();
    }
}
