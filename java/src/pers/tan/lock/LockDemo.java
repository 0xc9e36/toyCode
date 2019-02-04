package pers.tan.lock;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LockDemo {
    public static void createWaitThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        }, "createWaitThread") {}.start();
    }

    public static void createLoclThread(final Object lock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "createLoclThread") {}.start();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.read();
        createWaitThread();
        bufferedReader.read();
        Object o = new Object();
        createLoclThread(o);
    }
}
