package pers.tan.example;

public class Example1 {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        subThread.start();
        synchronized (subThread) {
            for(int i = 1; i <= 50; ++i) {
                try {
                    subThread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int j = 1; j <= 20; ++j) {
                    System.out.println("主线程循环第" + j + "次");
                }
                System.out.println("-------------------循环 " + i +" 次过了-----------------");
                subThread.notifyAll();
            }
        }
    }
}


class SubThread extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            for (int j = 1; j <= 50; ++j) {
                notifyAll();
                for(int i = 1; i <= 10; ++i) {
                    System.out.println("子线程循环第" + i + "次");
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
