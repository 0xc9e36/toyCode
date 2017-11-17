package pers.tan.collection;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * MapTest class
 *
 * @author tanwei
 * @date 17-11-17
 */
public class MapTest {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        Map map1 = new LinkedHashMap();
        Map map2 = new TreeMap();
        Map map3 = new Hashtable();

        map.put("name","张小仙");
        map.put("age", 18);
        Collection collection = map.values();
        System.out.println(collection);

        Set entrySet = map.entrySet();
        for(Object object:entrySet) {
            Map.Entry entry = (Map.Entry)object;
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("jdbc.properties")));
        String user = properties.getProperty("user");
        System.out.println(user);
    }
}
