package pers.tan.threadstatus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExectuorTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; ++i) {
            Runnable work = new WorkerThread(i+"");
            executor.execute(work);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
    }
}

class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(command);
    }
}