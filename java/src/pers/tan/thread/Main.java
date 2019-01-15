package pers.tan.thread;

public class Main {

    public static void main(String[] args) {


        HasSelfPrivateNum h1 = new HasSelfPrivateNum();
        //HasSelfPrivateNum h2 = new HasSelfPrivateNum();

        ThreadA threadA = new ThreadA(h1);
        threadA.start();

        ThreadB threadB = new ThreadB(h1);
        threadB.start();
        System.out.println(threadB.getState());
    }
}


class HasSelfPrivateNum {

    private int num = 0;

    synchronized public void add(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                //如果去掉thread.sleep(2000)，那么运行结果就会显示为同步的效果
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.add("a");
    }
}



class ThreadB extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        numRef.add("b");
    }

}

