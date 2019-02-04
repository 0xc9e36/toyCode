package pers.tan.thread;

public class YieldTest {
    public static void main(String[] args) {
        Thread11 thread11 = new Thread11("线程a");
        thread11.start();

        Thread11 thread12 = new Thread11("线程B");
        thread12.start();
    }
}

class Thread11 extends Thread {
    public Thread11(String name) {
        this.setName(name);
    }
    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
            if (i%4 == 0) {
                Thread.yield();
            }
        }
    }
}
