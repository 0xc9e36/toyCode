package pers.tan.thread;

import java.util.ArrayList;
import java.util.List;

public class NotifyTest {
    public static void main(String[] args) {
        Object lock = new Object();

        Threada a = new Threada(lock);
        a.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();

//        Threadb b = new Threadb(lock);
//        b.start();
    }
}


class MyList {
    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}

class Threada extends Thread {
    private Object lock;

    public Threada(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (MyList.size() != 5) {
                System.out.println("wait begin "
                        + System.currentTimeMillis());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end  "
                        + System.currentTimeMillis());
            }
        }
    }
}

class Threadb extends Thread {
    private Object lock;

    public Threadb(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                MyList.add();
                if (MyList.size() == 5) {
                    lock.notify();
                    System.out.println("已发出通知！");
                }
                System.out.println("添加了" + (i + 1) + "个元素!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}