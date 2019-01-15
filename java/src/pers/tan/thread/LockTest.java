package pers.tan.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {

//        MyService service = new MyService();
//
//        MyThread a1 = new MyThread(service);
//        MyThread a2 = new MyThread(service);
//        MyThread a3 = new MyThread(service);
//        MyThread a4 = new MyThread(service);
//        MyThread a5 = new MyThread(service);
//
//        a1.start();
//        a1.setName("a");
//        a2.start();
//        a2.setName("b");
//        a3.start();
//        a3.setName("c");
//        a4.start();
//        a4.setName("d");
//        a5.start();
//        a5.setName("e");

        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            service.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public class MyService {
        private Lock lock = new ReentrantLock();

        public Condition condition = lock.newCondition();

        public void await() {
            lock.lock();
            try {
                System.out.println(" await时间为" + System.currentTimeMillis());
                condition.await();
                System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signal() throws InterruptedException {
            lock.lock();
            try {
                System.out.println("signal时间为" + System.currentTimeMillis());
                condition.signal();
                Thread.sleep(3000);
                System.out.println("这是condition.signal()方法之后的语句");
            } finally {
                lock.unlock();
            }
        }

        public void testMethod() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } finally {
                lock.unlock();
            }

        }

    }

    static public class ThreadA extends Thread {

        private MyService service;

        public ThreadA(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.await();
        }
    }


    static public class MyThread extends Thread {

        private MyService service;

        public MyThread(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }
}
