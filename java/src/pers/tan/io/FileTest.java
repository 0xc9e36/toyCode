package pers.tan.io;

import java.io.File;
import java.io.IOException;

/**
 * Main class
 *
 * @author tanwei
 * @date 17-11-19
 */
public class FileTest {
    public static void main(String[] args) {
        test4();
    }

    public static void test4() {
        traversal(new File("/opt"));
        System.out.println("最小文件是:" + min.getName() + ",大小为:" + min.length() / 1024 + "kb");
        System.out.println("最大文件是:" + max.getName() + ",大小为:" + max.length() / 1024 + "kb");
    }

    static long maxSize = Long.MIN_VALUE;
    static long minSize = Long.MAX_VALUE;
    static File max = null;
    static File min = null;

    public static void traversal(File file) {

        if (file.isFile()) {
            if (file.length() > maxSize) {
                max = file;
                maxSize = file.length();
            }
            if(file.length() < minSize) {
                min = file;
                minSize = file.length();
            }
            return ;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) {
                return ;
            }
            for(File f:files) {
                traversal(f);
            }
        }
    }

    public static void test3() {
        File file = new File("/opt/test/file");
        //列出所有盘符
        File[] files = File.listRoots();
        for(File f:files) {
            System.out.println(f.getName());
        }
        //删除文件，不是文件夹
        //file.delete();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // JVM结束的时候，刪除文件，常用于临时文件的删除
        file.deleteOnExit();
    }

    public static void test2() {
        File file = new File("/opt");

        //文件夹下所有文件名
        String[] fileNames = file.list();

        //文件夹下所有文件
        File[] files = file.listFiles();

        //当前文件目录
        System.out.println("当前文件目录：" + file.getParent());

        //创建文件夹
        File file1 = new File("/opt/test");
        boolean isMkdir = file1.mkdir();
        System.out.println("创建文件夹:" + isMkdir);

        //递归创建文件夹
        File file2 = new File("/opt/test/hello/world");
        boolean isMkdirs = file2.mkdirs();
        System.out.println("递归创建文件夹:" + isMkdirs);

        //创建空文件
        File file3 = new File("/opt/test/file");
        try {
            boolean isCreateNewFile = file3.createNewFile();
            System.out.println(isCreateNewFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void test1() {
        File file = new File("/opt/file.txt");

        //判断是否存在
        System.out.println("文件是否存在:" + file.exists());

        //是否是目录
        System.out.println("是否是目录文件:" + file.isDirectory());

        //获取文件长度
        System.out.println("文件长度:" + file.length());

        //文件最后修改时间
        long lastModifyTime = file.lastModified();
        System.out.println("文件最后修改时间:" + lastModifyTime);

        //文件名修改
        //File newFile = new File("/opt/new.file");
        //file.renameTo(newFile);
        //System.out.println("文件改名了");
    }
}
