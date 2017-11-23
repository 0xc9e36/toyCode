package pers.tan.io;

import java.io.*;
import java.util.Arrays;

/**
 * StreamTest class
 *
 * @author tanwei
 * @date 17-11-19
 */
public class StreamTest {
    public static void main(String[] args) {
        //in();
        //out();

        /*
        int eachSize = 1; // 1B
        File srcFile = new File("/opt/test/A/B/a.txt");
        cutFile(srcFile, eachSize);
        */

        mergeFile("/opt/test/A/B", "a.txt");
    }
    public static void in() {
        File f =new File("/opt/test/A/B/a.txt");
        try (InputStream fis =new FileInputStream(f)) {
            byte[] bytes = new byte[(int)f.length()];

            fis.read(bytes);

            for(byte b:bytes) {
                System.out.println(b);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void out()  {
        //递归创建父目录
        try {
            File o =new File("/opt/test/A/B/a.txt");
            File dir = o.getParentFile();

            if (!dir.exists()) {
                dir.mkdirs();
            }

            int size = 500 * 1024;
            byte[] data = new byte[size];

            for(int i = 0; i < size; i++) {
                data[i] = (byte) (i%Byte.MAX_VALUE);
            }
            OutputStream os = new FileOutputStream(o);

            os.write(data);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 切分文件
     * @param srcFile
     * @param eachSize
     */
    public static void cutFile(File srcFile, int eachSize) {
        if (0 == srcFile.length()) {
           return ;
        }

        byte[] fileContent = new byte[(int)srcFile.length()];
        try {
            InputStream is = new FileInputStream(srcFile);
            is.read(fileContent);
            for(byte b:fileContent) {
                System.out.println(b);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int fileNumber;
        if (0 == fileContent.length % eachSize) {
            fileNumber = (int) (fileContent.length / eachSize);
        } else {
            fileNumber = (int) (fileContent.length / eachSize) + 1;
        }

        for (int i = 0; i < fileNumber; i++) {
            String eachFileName = srcFile.getName() + "-" + i;
            File eachFile = new File(srcFile.getParent(), eachFileName);
            byte[] eachContent;

            // 从源文件的内容里，复制部分数据到子文件
            // 除开最后一个文件，其他文件大小都是100k
            // 最后一个文件的大小是剩余的
            if (i != fileNumber - 1) {// 不是最后一个
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
            } else { // 最后一个
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);
            }
            try {
                // 写出去
                FileOutputStream fos = new FileOutputStream(eachFile);
                fos.write(eachContent);
                // 记得关闭
                fos.close();
                System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 合并文件
     * @param folder
     * @param fileName
     */
    public static void mergeFile(String folder, String fileName) {
        try {
            // 合并的目标文件
            File destFile = new File(folder, fileName);
            FileOutputStream fos = new FileOutputStream(destFile);
            int index = 0;
            while (true) {
                //子文件
                File eachFile = new File(folder, fileName + "-" + index++);
                //如果子文件不存在了就结束
                if (!eachFile.exists()) {
                    break;
                }
                //读取子文件的内容
                FileInputStream fis = new FileInputStream(eachFile);
                byte[] eachContent = new byte[(int) eachFile.length()];
                fis.read(eachContent);
                fis.close();

                //把子文件的内容写出去
                fos.write(eachContent);
                fos.flush();
                System.out.printf("把子文件 %s写出到目标文件中%n",eachFile);
            }

            fos.close();
            System.out.printf("最后目标文件的大小：%,d字节" , destFile.length());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
