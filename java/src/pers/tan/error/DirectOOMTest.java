package pers.tan.error;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectOOMTest {
    private static final int size = 1024*1024;

    public static void main(String[] args) throws Exception{
        Field unsafe = Unsafe.class.getDeclaredFields()[0];
        unsafe.setAccessible(true);
        Unsafe unsafe1 = (Unsafe)unsafe.get(null);
        while (true) {
            unsafe1.allocateMemory(size);
        }
    }
}
