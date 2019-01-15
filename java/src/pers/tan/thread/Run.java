package pers.tan.thread;

public class Run {
    public static void main(String[] args) {
        //.执行方式1
//        MyThread myThread1 = new MyThread("Thread1");
//        myThread1.setPriority(10);
//        myThread1.start();
//
//        Thread.currentThread().setPriority(8);
        //2.执行方式2
//        MyRunnable runnable = new MyRunnable();
//        Thread thread = new Thread(runnable);
//        thread.start();

//        try {
//            Thread.sleep(500);
//            myThread1.interrupt();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        //守护线程
//        DaemonThread daemonThread = new DaemonThread();
//        daemonThread.setDaemon(true);
//        daemonThread.start();
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(daemonThread.isAlive());
        System.out.println("主方法执行完毕");

    }
}


class MyThread extends Thread {

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println("线程执行, 线程优先级:" + this.getPriority());
        for(int i = 0; i < 10; ++i) {
            if(this.isInterrupted()) {
                System.out.println("线程退出");
                break;
            }
            System.out.println(i);
        }
        System.out.println("线程执行完毕");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程执行");
        for(int i = 0; i < 5000000; ++i) {
            System.out.println(i);
        }
    }
}


class DaemonThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(i++ + "   id=" + this.getId());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}