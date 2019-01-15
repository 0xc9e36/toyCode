package pers.tan.thread;

public class WaitTest {
    public static void main(String[] args) {
        WaitThread t = new WaitThread();
        synchronized (t) {
            t.start();

            // 主线程等待t1通过notify()唤醒。
            System.out.println(Thread.currentThread().getName()+" wait()");

            try {
                t.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("主线程执行完毕");
        }
    }
}


class WaitThread extends Thread {
    @Override
    public void run() {
        synchronized (this) {
//            System.out.println("当前线程:" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(30000);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            //notify();
            System.out.println("子线程执行完毕");
        }

//        System.out.println("当前线程:" + Thread.currentThread().getName());
//        while (true);
    }
}