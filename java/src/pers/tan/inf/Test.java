package pers.tan.inf;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        String[] strings = new String[]{"a", "sfv", "da"};
        Arrays.sort(strings, new LengthComparator());
        for(String s : strings){
            System.out.println(s);
        }

    }

}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

