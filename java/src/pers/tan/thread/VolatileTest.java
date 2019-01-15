package pers.tan.thread;

public class VolatileTest {
    public static void main(String[] args) {
//        ThreadRun thread = new ThreadRun();
//
//        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.setIsRunning(false);
//
//        System.out.println("已经赋值为false");

        ThreadTest[] mythreadArray = new ThreadTest[100];

        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new ThreadTest();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }
    }
}


class ThreadRun extends Thread {

    boolean  isRunning = true;

    int m;

    public boolean getIsRunning() {
        return this.isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning) {
            int a = 2;
            int b = 3;
            int c = a + b;
            m = c;
            System.out.println("haha");
        }
        System.out.println(m);
        System.out.println("线程被停止了！");
    }
}



class ThreadTest extends Thread {

    private static int count;

    public synchronized static void add() {
        for(int i = 0; i < 100; ++i) {
            count = i;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        add();
    }

}