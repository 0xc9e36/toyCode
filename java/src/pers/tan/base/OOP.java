package pers.tan.base;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

/**
 * OOP class
 *
 * @author tanwei
 * @date 17-11-14
 */
public class OOP {

    public static void main(String[] args) {
        // 多态，编译时类型和运行时类型不一致
        // 编译时类型由声明(等号左边)决定，运行时类型由实际复制给变量的类型(等号右边)决定
        Parent son = new Son();
        //编译错误，因为属性是在编译时确定的，而Parent没有age属性
        //son.age = 18;
        //调用方法确可以，因为方法调用是在运行时确定的——称为动态绑定
        son.say();
        C c = new C();
        c.say();
    }

}

class A {
    public String name = "A";
}

class B extends A {
    public String name = "B";
    public void say() {
        System.out.println(this.name);
    }
}

class C extends B {
    public String name = "C";
}


class Parent {
    public String name = "Parent";
    public Parent() {
        System.out.println("父类构造器");
    }
    public void say() {
        // 输出 Parent
        System.out.println(this.name);
    }
    public void testOverride() throws Exception {

    }
}

class Son extends Parent {
    public String name = "Son";
    private int age;

    // 方法重写时：
    // 子类抛出异常不能大于父类异常
    // 子类访问权限不能小于父类
    @Override
    public void testOverride() throws  IOException {

    }
}

