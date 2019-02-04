package pers.tan.threadstatus;

import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) throws Exception{

        ExecutorService pool = Executors.newFixedThreadPool(2);
        EThread t1 = new EThread();
        EThread t2 = new EThread();
        EThread t3 = new EThread();
        EThread t4 = new EThread();
        EThread t5 = new EThread();
        EThread t6 = new EThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.shutdown();
    }
}

class EThread extends  Thread {
    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "执行了");
    }
}