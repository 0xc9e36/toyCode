package pers.tan.base;


import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * DataType class
 *
 * @author tanwei
 * @date 17-11-13
 */
public class DataType {
    public static void main(String[] args) {

        //baseType();
        system();
        refType();

        //强制类型转换
        String str = "43";
        System.out.println(Integer.parseInt(str));

        String str1 = "hello";
        String str2 = "hello";
        String str3 = "hel" + "lo";
        String str4 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);

        System.out.println(-3%2);

        conversionTypeTest();

    }


    //基本数据类型
    public static void baseType() {
        byte a = 1;
        System.out.println("byte:" + a);

        short b = 2;
        System.out.println("short:" + b);

        int c = 3;
        System.out.println("int:" + c);

        //不加L默认为int
        long d = 2147483648L;
        System.out.println("long:" + d);

        //浮点必须加f
        float e = .414f;
        System.out.println("float:" + e);
        // 500 * 10^2
        float f = 500e2f;
        System.out.println("float:" + f);

        double g = 3.14;
        System.out.println("double:" + g);


        //char占两个字节，能表示部分Unicode字符（包含常用中文）
        //内存中描述char采用UTF-16编码
        //UTF-16是Unicode字符集的一种实现方式，采用变长编码，两字节或四字节，16表示最低16位表示
        char h = '中';
        System.out.println("char:" + h);

        boolean isTrue = true;
        System.out.println(isTrue);

        System.out.println(1.2f + "a");
        System.out.println(3 + 4 + "a");
        //97Hello
        System.out.println('a' + 1 + "Hello");
        //Helloa1
        System.out.println("Hello" + 'a' + 1);
    }

    public static void refType() {
        short a1 = 1;
        short a2 = 2;
        //short a3 = a1 + a2;

        //引用数据类型初始化值都为null
        Object[] objects = new Object[5];

        int[] nums = new int[10];
        for(int i = 0; i < nums.length; ++i) {
        }
        System.out.println(10 + "a");

        System.out.println("-----------------------------------");
    }

    public static void conversionTypeTest() {
        //编译不通过，因为byte和short计算时都会首先转成int，不会相互转换
        /*
        byte b1 = 5;
        short s1 = 3;
        short t1 = s1 + b1;
        */

        //同样编译不通过
        /*
        short  s = 5;
        s = s-2;
        */

        String a = "hello";
        switch (a) {
            case "hello":
                System.out.println(a);
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }

    }

    public static void system() {
        //byte 8 个字节最高位是符号位，整数为0，负数为1，能表示最大127
        byte bMax = 0b01111111;
        //负数用补码表示，最小 -128
        byte bMin = 0b1000000;
    }
}

