package pers.tan.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ReaderTest class
 *
 * @author tanwei
 * @date 17-11-20
 */
public class ReaderTest {
    public static void main(String[] args) {
        write();
        //System.out.println((char)('a' + 1));
        //encodeFile(new File("/opt/test/A/B/char.txt"));
    }

    public static void write() {
        File file = new File("/opt/test/A/B/char.txt");
        try (FileWriter fw = new FileWriter(file) ){
            char[] dara = {'h','e','l','l','o',',','w','o','r','l','d','\n','你','好','世','界','\n'};
            fw.write(dara);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        File file = new File("/opt/test/A/B/char.txt");

        try (FileReader fr = new FileReader(file)) {
            char[] data = new char[(int)file.length()];
            fr.read(data);
            for(char ch : data) {
                System.out.print(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encodeFile(File file) {
    }
}
