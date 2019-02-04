//package pers.tan.reflect;
//
//import java.lang.invoke.MethodHandle;
//import java.lang.invoke.MethodHandles;
//import java.lang.invoke.MethodType;
//
//public class Initialization5 {
//    public static void main(String[] args) {
//        MethodHandles.Lookup lookup = MethodHandles.lookup();
//        try {
//            MethodHandle testMethodHandle = lookup.findStatic(MethodHandleClass.class, "testMethodHandle", MethodType.methodType(void.class, String.class));
//            try {
//                testMethodHandle.invoke("当使用JDK 1.7 的动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的结果是\n" +
//                        "REF_getStatic、REF_putStatic、REF_invokeStatic的方法句柄，并且这个方法句柄对应的类没有进行过初始化，则需要先触发其初始化");
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//}
