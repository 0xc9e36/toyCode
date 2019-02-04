package pers.tan.exception;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class
 *
 * @author tanwei
 * @date 17-11-17
 */
public class Main {
//    public static void main(String[] args) {
//        URL url = null;
//        List<ClassLoader> classLoaderList = new ArrayList<>();
//        try {
//            url = new File("/tmp").toURI().toURL();
//            URL[] urls = {url};
//            while (true){
//                ClassLoader loader = new URLClassLoader(urls);
//                classLoaderList.add(loader);
//                loader.loadClass("pers.tan.exception.Main");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
