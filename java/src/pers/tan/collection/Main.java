package pers.tan.collection;

import java.util.*;

/**
 * Main class
 *
 * @author tanwei
 * @date 17-11-17
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
        for(String s:list){
            if("a".equals(s)){
                list.remove(s);
            }
        }
    }
}
