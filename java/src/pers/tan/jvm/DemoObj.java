package pers.tan.jvm;

public class DemoObj {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }

        //PC计数器超出代码块的作用域, placeholder所占的solt可以被重用，这里被 a 覆盖掉了
        int a = 0;
        System.gc();
    }
}
