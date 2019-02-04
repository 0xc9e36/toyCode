package pers.tan.design;

public class SingletonTest {
    public static void main(String[] args) {
    }
}


//创建方式1
//class Singleton {
//    private static volatile Singleton singleton = null;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}


//创建方式2
//class Singleton{
//    private static class SingletonHold {
//        private static volatile Singleton INSTANCE = new Singleton();
//    }
//    public static Singleton getInstance() {
//        return SingletonHold.INSTANCE;
//    }
//}