package pers.tan.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class Demo {

    public static void main(String[] args) throws Exception {
//        try {
//            Class clazz = Class.forName(getValue("className"));
//            Object obj = clazz.newInstance();
//            Method method = clazz.getDeclaredMethod(getValue("methodName"), String.class);
//            method.setAccessible(true);
//            method.invoke(obj, "小明");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        Class clazz = strList.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(strList, 100);

        System.out.println(method.getModifiers());
        //遍历集合
        for(Object obj : strList){
            System.out.println(obj.getClass().getTypeName());
        }
    }



    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fir = new FileInputStream("/home/tan/work/toyCode/target/production/toyCode/pro.properties");
        properties.load(fir);
        fir.close();
        return properties.getProperty(key);

    }

}

