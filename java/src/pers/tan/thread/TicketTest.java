package pers.tan.thread;

public class TicketTest {
    public static void main(String[] args) {
//        TicketThread t1 = new TicketThread();
//        TicketThread t2 = new TicketThread();
//        TicketThread t3 = new TicketThread();
//        t1.start();
//        t2.start();
//        t3.start();

        TicketThread2 ticketThread2 = new TicketThread2();
        Thread t1 = new Thread(ticketThread2);
        Thread t2 = new Thread(ticketThread2);
        Thread t3 = new Thread(ticketThread2);
        Thread t4 = new Thread(ticketThread2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class TicketThread2 implements Runnable {
    private int count = 100;

    @Override
    public synchronized void run() {
        while (count > 0) {
            if (count > 0) {
                System.out.println("线程" + Thread.currentThread().getName() + "卖出了第" + count-- + "张票");
            }
            try {
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            notifyAll();
        }
    }
}


class TicketThread extends Thread {
    private int count = 10;

    @Override
    public void run() {
        while (count > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "卖出了第" + count-- + "张票");
        }
    }

}
