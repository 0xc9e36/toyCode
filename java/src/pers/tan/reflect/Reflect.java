package pers.tan.reflect;


import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws Exception{
//        //第一种方式获取Class对象
//        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。
//        Class stuClass = stu1.getClass();//获取Class对象
//        System.out.println(stuClass.getName());
//
//        //第二种方式获取Class对象
//        Class stuClass2 = Student.class;
//        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
//
//        //第三种方式获取Class对象
//        try {
//            Class stuClass3 = Class.forName("pers.tan.reflect.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
//            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }






//        //1.加载Class对象
//        Class clazz = Class.forName("pers.tan.reflect.Student");
//
//
//        //2.获取所有公有构造方法
//        System.out.println("**********************所有公有构造方法*********************************");
//        Constructor[] conArray = clazz.getConstructors();
//        for(Constructor c : conArray){
//            System.out.println(c);
//        }
//
//
//        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
//        conArray = clazz.getDeclaredConstructors();
//        for(Constructor c : conArray){
//            System.out.println(c);
//        }
//
//        System.out.println("*****************获取公有、无参的构造方法*******************************");
//        Constructor con = clazz.getConstructor(null);
//        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
//        //2>、返回的是描述这个无参构造函数的类对象。
//
//        System.out.println("con = " + con);
//        //调用构造方法
//        Object obj = con.newInstance();
//        //	System.out.println("obj = " + obj);
//        //	Student stu = (Student)obj;
//
//        System.out.println("******************获取私有构造方法，并调用*******************************");
//        con = clazz.getDeclaredConstructor(char.class);
//        System.out.println(con);
//        //调用构造方法
//        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
//        obj = con.newInstance('男');



//        //1.获取Class对象
//        Class stuClass = Class.forName("pers.tan.reflect.Student");
//        //2.获取字段
//        System.out.println("************获取所有公有的字段********************");
//        Field[] fieldArray = stuClass.getFields();
//        for(Field f : fieldArray){
//            System.out.println(f);
//        }
//        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
//        fieldArray = stuClass.getDeclaredFields();
//        for(Field f : fieldArray){
//            System.out.println(f);
//        }
//        System.out.println("*************获取公有字段**并调用***********************************");
//        Field f = stuClass.getField("name");
//        System.out.println(f);
//        //获取一个对象
//        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
//        //为字段设置值
//        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
//        //验证
//        Student stu = (Student)obj;
//        System.out.println("验证姓名：" + stu.name);
//
//
//        System.out.println("**************获取私有字段****并调用********************************");
//        f = stuClass.getDeclaredField("phoneNum");
//        System.out.println(f);
//        f.setAccessible(true);//暴力反射，解除私有限定
//        f.set(obj, "18888889999");
//        System.out.println("验证电话：" + stu);


        //1.获取Class对象
        Class stuClass = Class.forName("pers.tan.reflect.Student");
        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        stuClass.getMethods();
        Method[] methodArray = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("***************获取私有的show4()方法******************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);


        System.out.println("main");
        Method me = stuClass.getDeclaredMethod("main", String[].class);
        me.invoke(null, (Object) new String[]{});
    }
}


class Student {
//
//    //---------------构造方法-------------------
//    //（默认的构造方法）
//    Student(String str) {
//        System.out.println("(默认)的构造方法 s = " + str);
//    }
//
//    //无参构造方法
//    public Student() {
//        System.out.println("调用了公有、无参构造方法执行了。。。");
//    }
//
//    //有一个参数的构造方法
//    public Student(char name) {
//        System.out.println("姓名：" + name);
//    }
//
//    //有多个参数的构造方法
//    public Student(String name, int age) {
//        System.out.println("姓名：" + name + "年龄：" + age);//这的执行效率有问题，以后解决。
//    }
//
//    //受保护的构造方法
//    protected Student(boolean n) {
//        System.out.println("受保护的构造方法 n = " + n);
//    }
//
//    //私有构造方法
//    private Student(int age) {
//        System.out.println("私有的构造方法   年龄：" + age);
//    }

//    public Student(){
//
//    }
//    //**********字段*************//
//    public String name;
//    protected int age;
//    char sex;
//    private String phoneNum;
//
//    @Override
//    public String toString() {
//        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
//                + ", phoneNum=" + phoneNum + "]";

    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private java.lang.String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

    private void show(String name) {
        System.out.println("反射 : show()" + name);
    }

    public static void main(String[] args) {
        System.out.println("-----------main-------------");
    }
}
