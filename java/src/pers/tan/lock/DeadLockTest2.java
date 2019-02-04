package pers.tan.lock;

public class DeadLockTest2 {
    public static void main(String[] args) {

        for (int i = 0; i < 100; ++i) {
            new Thread(new T(1, 2)){}.start();
            new Thread(new T(2, 1)){}.start();
        }
    }
}


class T implements Runnable {
    private int a;
    private int b;
    public T(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a+b);
            }
        }
    }
}