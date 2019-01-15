package pers.tan.thread;

class MyObject {

}

public class Run1_1 {
    public static void main(String[] args) {
        Service service = new Service();
        MyObject myObject = new MyObject();


        Thread5 thread5 = new Thread5(service, myObject);
        thread5.setName("c");
        thread5.start();

        Thread3 thread3 = new Thread3(service, myObject);
        thread3.setName("a");
        thread3.start();

        Thread4 thread4 = new Thread4(service, myObject);
        thread4.setName("b");
        thread4.start();


    }
}


//静态同步synchronized方法与synchronized(class)代码块持有的锁一样，都是Class锁，
// Class锁对对象的所有实例起作用。synchronized关键字加到非static静态方法上持有的是对象锁。
class Service {
    public void test(MyObject object) {
        synchronized (object) {
            System.out.println("线程开始：" + Thread.currentThread().getName() + " time:" + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束：" + Thread.currentThread().getName()+ " time:" + System.currentTimeMillis());
        }
    }

    public synchronized void test2() {
        System.out.println("线程开始：" + Thread.currentThread().getName() + " time:" + System.currentTimeMillis());
        System.out.println("线程结束：" + Thread.currentThread().getName()+ " time:" + System.currentTimeMillis());
    }

    public synchronized static void test3() {
        System.out.println("线程开始：" + Thread.currentThread().getName() + " time:" + System.currentTimeMillis());
        System.out.println("线程结束：" + Thread.currentThread().getName()+ " time:" + System.currentTimeMillis());
    }

    public static void test4() {
        synchronized (Service.class) {
            System.out.println("线程开始：" + Thread.currentThread().getName() + " time:" + System.currentTimeMillis());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程结束：" + Thread.currentThread().getName()+ " time:" + System.currentTimeMillis());
        }
    }
}
class Thread3 extends Thread {
    private Service service;
    private MyObject object;

    public Thread3(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.test2();
    }
}

class Thread4 extends Thread {
    private Service service;
    private MyObject object;

    public Thread4(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.test3();
    }
}

class Thread5 extends Thread {
    private Service service;
    private MyObject object;

    public Thread5(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.test4();
    }
}