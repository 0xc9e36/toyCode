package pers.tan.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * ListTest class
 *
 * @author tanwei
 * @date 17-11-17
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(0);
        list.add(1);
        list.add(1,2);

        list.remove(2);

        System.out.println(list);

        List list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        System.out.println(list1);

        List list2 = new Vector();
        list2.add(1);
        list2.add(8);
        System.out.println(list2);
    }
}
