package pers.tan.designpattern;

/**
 * Singleton class
 *
 * @author tanwei
 * @date 17-11-16
 */



public class SingletonTest {


    public static void main(String[] args) {

        SingletonDemo1 singleton1 = SingletonDemo1.getInstance();
        SingletonDemo1 singleton2 = SingletonDemo1.getInstance();
        System.out.println(singleton1 == singleton2);

        System.out.println("----------------------------------------------------");

        SingletonDemo2 singleton3 = SingletonDemo2.getInstance();
        SingletonDemo2 singleton4 = SingletonDemo2.getInstance();
        System.out.println(singleton4 == singleton3);

        System.out.println("----------------------------------------------------");
        /*
        Mythrad[] mythrads = new Mythrad[10];
        for(int i = 0; i < mythrads.length; ++i) {
            mythrads[i] = new Mythrad();
        }

        for(int i = 0; i < mythrads.length; ++i) {
            mythrads[i].start();
        }
        */
        SingletonDemo3 singleton5 = SingletonDemo3.getInstance();
        SingletonDemo3 singleton6 = SingletonDemo3.getInstance();
        System.out.println(singleton5 == singleton6);

        System.out.println("----------------------------------------------------");
        SingletonDemo4 singleton7 = SingletonDemo4.INSTANCE;
        SingletonDemo4 singleton8 = SingletonDemo4.INSTANCE;
        singleton7.doSomeThing();
        System.out.println(singleton7 == singleton8);
    }
}



/*饿汉式*/
class SingletonDemo1 {

    private static final SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1(){
        System.out.println("SingletonDemo1");
    }

    public static SingletonDemo1 getInstance() {
        return instance;
    }
}

/*懒汉式*/
class SingletonDemo2 {

    private static volatile SingletonDemo2 instance = null;

    private SingletonDemo2(){
        System.out.println("SingletonDemo2");
    }

    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            synchronized (Object.class){
                if (instance == null) {
                    instance = new SingletonDemo2();
                }
            }
        }
        return instance;
    }
}

/*内部静态类*/
class SingletonDemo3 {
    private static class Singleton {
        private static final SingletonDemo3 INSTANCE = new SingletonDemo3();
    }
    public static SingletonDemo3 getInstance() {
        return Singleton.INSTANCE;
    }
    private SingletonDemo3() {

    }
}


/*枚举*/
enum SingletonDemo4 {
    //定义一个枚举的元素，它就是 Singleton 的一个实例
    INSTANCE;

    public void doSomeThing() {
        // do something...
        System.out.println("单例哟");
    }
}

class Mythrad extends Thread {

    @Override
    public void run() {
        System.out.println(SingletonDemo2.getInstance().hashCode());
    }
}
