package pers.tan.oop;


import java.lang.reflect.Constructor;

class Employee {
    public Employee() {

    }
    public Employee(int a) {
        System.out.println("父类带参数构造器");
    }
}

public class Manager extends Employee {
    public Manager() {
        super(1);
    }

    private Manager(int a, int b) {

    }
    public static void main(String[] args) {
        try {
            Class c1 = Class.forName("pers.tan.oop.Manager");
//            Class c2 = Manager.class;
//
//            Manager m1 = new Manager();
//            Class c3 = m1.getClass();

            Constructor[] constructors = c1.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

		Constructor con = c1.getConstructor(null);
        con.newInstance();

            //Manager m2 = (Manager)c1.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

