package pers.tan.code;

/**
 * ObjectTest class
 *
 * @author tanwei
 * @date 17-11-15
 */
public class ObjectTest {
    public static void main(String[] args) {
        /*
        ObjectTest objectTest = new ObjectTest();
        try {
            ObjectTest obj = (ObjectTest)objectTest.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        */
        User user1 = new User();
        user1.setUid(1);
        user1.setName("张小仙");
        User user2 = new User();
        user2.setUid(1);
        user2.setName("张小絮");

        System.out.println(user1.equals(user2));

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        System.out.println(new Object());

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        synchronized (thread) {
            try {
                System.out.println("maint hread 等待t线程执行完");
                thread.wait();
                System.out.println("被notity唤醒，得以继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            notify();
            System.out.println("执行notif后同步代码块中依然可以继续执行直至完毕");
        }
    }
}


class User {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUid() {

        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    private int uid;

    private String name;

    private int age;

    @Override
    public boolean  equals(Object obj) {
        if (obj == null || !(obj instanceof User)) {
           return false;
        }
        return this.getUid() == ((User) obj).getUid();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getUid();
        return result;
    }
}
