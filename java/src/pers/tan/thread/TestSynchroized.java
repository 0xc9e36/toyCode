package pers.tan.thread;

public class TestSynchroized {
    public static void main(String[] args) {

        PublicVar p = new PublicVar();

        Thread1 thread1 = new Thread1(p);
        thread1.start();

        try {
            Thread1.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p.getValue();
    }
}


class Thread1 extends Thread {

    private PublicVar publicVar;

    public Thread1(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}

class PublicVar {
    public String username = "A";
    public String password = "AA";

    public synchronized void setValue(String username, String password) {
        this.username = username;

        try {
            Thread1.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.password = password;
        System.out.println("set value" + "username="+username + " password="+password);
    }

    public synchronized void getValue() {
        System.out.println("get value" + "username="+username + " password="+password);
    }
}