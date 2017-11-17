package pers.tan.code;

/**
 * StringTest class
 *
 * @author tanwei
 * @date 17-11-16
 */
public class StringTest {
    public static void main(String[] args) {
        //字符串常量池
        String string1 = "Hello";
        String string2 = "Hello";
        //创建了一个字符串对象，位于堆空间
        String string3 = new String("Hello");
        System.out.println(string1.equals(string2));
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);
    }
}
