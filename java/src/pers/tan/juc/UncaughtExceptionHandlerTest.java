package pers.tan.juc;

public class UncaughtExceptionHandlerTest {
    public static void main(String[] args) {
        Thread t = new Thread(new AdminThread());
        t.setDefaultUncaughtExceptionHandler(new ExceptionHandler()); //对当前线程设置默认catch
        t.start();
    }
}

class AdminThread implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("start ... Exception");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new NullPointerException(); //直接exception
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) { //调用此方法来进行，对异常处理，需要实现UncaughtExceptionHandler 接口
        System.out.println("Thread:" + t + " Exception message:" + e);
    }
}