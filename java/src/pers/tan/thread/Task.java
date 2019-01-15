package pers.tan.thread;

public class Task {
    private String d1;
    private String d2;

    public void doTask() {
        System.out.println("begin task " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            d1 = "value1, threadName = " + Thread.currentThread().getName();
            d2 = "value2, threadName = " + Thread.currentThread().getName();
        }



        System.out.println(d1);
        System.out.println(d2);

        System.out.println("end task " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Task task = new Task();
        MyThread1 myThread1 = new MyThread1(task);
        myThread1.start();

        MyThread2 myThread2 = new MyThread2(task);
        myThread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class CommonUtils {
    public static long beginTime1;
    public static long endTime1;

    public static long beginTime2;
    public static long endTime2;
}


class MyThread1 extends Thread {
    private Task task;

    public MyThread1(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doTask();
        CommonUtils.endTime1 = System.currentTimeMillis();

    }
}


class MyThread2 extends Thread {
    private Task task;
    public MyThread2(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}