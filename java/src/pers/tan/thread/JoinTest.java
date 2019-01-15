package pers.tan.thread;

public class JoinTest {
    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread();
        joinThread.start();

        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完");
    }
}


class JoinThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程执行完");
    }

}
