package pers.tan.threadstatus;

import java.util.Scanner;

public class TestThreadStatus {

    public static void testInBlockedIOState() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        // 创建一个名为“输入输出”的线程t
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 命令行中的阻塞读
                    String input = in.nextLine();
                    System.out.println(input);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }, "输入输出"); // 线程的名字

        // 启动
        t.start();

        // 确保run已经得到执行
        Thread.sleep(100);

        // 状态为RUNNABLE
        System.out.println(Thread.State.RUNNABLE);
    }


    public static void testBlocked() throws Exception {
        class Counter {
            int counter;
            public synchronized void increase() {
                counter++;
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                c.increase();
            }
        }, "t1线程");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                c.increase();
            }
        }, "t2线程");
        t2.start();

        Thread.sleep(100); // 确保 t2 run已经得到执行
        System.out.println(t2.getState().name());
    }


    public static void testReenterBlocked() throws Exception {
        class Account {
            int amount = 100; // 账户初始100元
            public synchronized void deposit(int cash) { // 存钱
                amount += cash;
                notify();
                try {
                    Thread.sleep(30000); // 通知后却暂时不退出
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            public synchronized void withdraw(int cash) { // 取钱
                while (cash > amount) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                amount -= cash;
            }
        }
        Account account = new Account();

        Thread withdrawThread = new Thread(new Runnable() {
            public void run() {
                account.withdraw(200);
            }
        }, "取钱线程");
        withdrawThread.start();

        Thread.sleep(100); // 确保取钱线程已经得到执行

        System.out.println(withdrawThread.getState().name());

        Thread depositThread = new Thread(new Runnable() {
            public void run() {
                account.deposit(100);
            }
        }, "存钱线程");
        Thread.sleep(10000); // 让取钱线程等待一段时间
        depositThread.start();

        Thread.sleep(300); // 确保取钱线程已经被存钱线程所通知到
        System.out.println(depositThread.getState().name());
    }

    public static void main(String[] args) throws Exception{
        //testInBlockedIOState();
        //testBlocked();
        testReenterBlocked();
    }
}
