package pers.tan.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * CloseStreamTest class
 *
 * @author tanwei
 * @date 17-11-20
 */
public class CloseStreamTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        File f = new File("/opt/test/A/B/a.txt");
        try (FileInputStream fis = new FileInputStream(f) ){
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
