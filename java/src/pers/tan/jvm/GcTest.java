package pers.tan.jvm;

public class GcTest {
    public static void main(String[] args) {
        {
            byte[] space = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
