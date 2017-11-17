package pers.tan.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * SetTest class
 *
 * @author tanwei
 * @date 17-11-17
 */
public class SetTest {
    public static void main(String[] args) {
        //维护了添加顺序
        Set set = new LinkedHashSet();
        set.add(null);
        set.add(8);
        set.add(45);
        set.add(49);
        set.add(1);
        set.add(2);
        set.add(2);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println("------------------------");

        Set set1 = new HashSet();
        set1.add(null);
        set1.add(8);
        set1.add(45);
        set1.add(49);
        set1.add(1);
        set1.add(2);
        set1.add(2);
        System.out.println(set1);
        System.out.println(set1.size());

        //只能添加一种类型
        Set set2 = new TreeSet();
        set2.add(2);
        set2.add(4);
        set2.add(78);
        System.out.println(set2);
    }
}
