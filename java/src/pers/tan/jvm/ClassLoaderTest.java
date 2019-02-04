package pers.tan.jvm;

import java.io.*;



public class ClassLoaderTest {
//    public static void main(String[] args) throws ClassNotFoundException {
//
//        String rootDir = "/home/tan/work/toyCode/java/src/pers/tan/jvm";
//        //创建两个不同的自定义类加载器实例
//        FileClassLoader loader1 = new FileClassLoader(rootDir);
//        FileClassLoader loader2 = new FileClassLoader(rootDir);
//        //通过findClass创建类的Class对象
//        Class<?> object1 = loader1.findClass("pers.tan.jvm.ClassLoaderTest");
//        Class<?> object2 = loader2.findClass("pers.tan.jvm.ClassLoaderTest");
//
//        System.out.println("findClass->obj1:" + object1.hashCode());
//        System.out.println("findClass->obj2:" + object2.hashCode());
//
////
////        FileClassLoader loader1 = new FileClassLoader("GcTest");
////
////        System.out.println("自定义类加载器的父加载器: "+loader1.getParent());
////        System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
////        System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
////        System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());
//
//        /**
//         输出结果:
//         自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
//         系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
//         AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
//         ExtClassLoader的父类加载器: null
//         */
//
//    }

    public static void main(String[] args) {
        String rootDir = "/home/tan/work";
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);

        try {
            //加载指定的class文件
            Class<?> object1=loader.loadClass("DemoObj");
            System.out.println(object1.newInstance().toString());

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        System.out.println("自定义加载器工作了");

        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑
     *
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);

        System.out.println(path);

        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) {
        String rootDir="/Users/zejian/Downloads/Java8_Action/src/main/java/";
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);

        try {
            //加载指定的class文件
            Class<?> object1=loader.loadClass("com.zejian.classloader.DemoObj");
            System.out.println(object1.newInstance().toString());

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
