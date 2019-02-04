package pers.tan.threadstatus;

import java.util.concurrent.*;

public class CallableTest1 {
    public static void main(String[] args) throws Exception{
        Cal cal = new Cal();
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(2);
        Future<Integer> res = threadPoolExecutor.submit(cal);
        System.out.println(res.get());
        threadPoolExecutor.shutdown();
    }
}


class Cal implements Callable<Integer> {
    @Override
    public Integer call() {
        return 11;
    }
}