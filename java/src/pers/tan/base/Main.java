package pers.tan.base;

import java.util.Arrays;

/**
 * Main class
 *
 * @author tanwei
 * @date 17-11-13
 */
public class Main {
    static {
        System.out.println("main");
    }
    //执行顺序：静态代码块->Main->构造代码块->构造器
    //静态代码块只在类加载时执行一次，构造代码块对所有对象进行初始化，而构造函数对当前对象初始化
    public static void main(String[] args) {
        new D();
        new D();
    }
}

class D {
    public D() {
        System.out.println("Construct");
    }

    //很明显，静态代码块只执行一次
    static {
        System.out.println("static code");
    }

    {
        System.out.println("code");
    }
}
