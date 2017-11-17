package pers.tan.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * CollectionTest class
 *
 * @author tanwei
 * @date 17-11-17
 */
public class CollectionTest {

    public static void main(String[] args) {
        /*
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add("123");
        collection.add(new User());
        //System.out.println(collection);

        Iterator iterator = collection.iterator();

        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------");

        for(Object o : collection) {
            System.out.println(o);
        }
        */
        System.out.println("-------------------------------");


        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");


        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        /*
        for (String item : list) {
            System.out.println(item);
        }
        */
    }
}

class User {
    private int age = 0;
}