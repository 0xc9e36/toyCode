package pers.tan.error;

public class StakeOOMTest {

    public static void main(String[] args) {
        StakeOOMTest stakeOOMTest = new StakeOOMTest();
        stakeOOMTest.stakeThread();
    }

    public  void test() {
        while (true) {

        }
    }

    public void stakeThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            });
            thread.start();
        }
    }
}
