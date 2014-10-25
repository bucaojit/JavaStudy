package maps;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Oliver on 10/24/14.
 */

/*
    Testing a Hashmap vs ConcurrentHashMap
 */

public class HashMapWork {
    HashMap<String, Integer> map;
    ConcurrentHashMap<String, Integer> cmap;

    HashMapWork() {
        map = new HashMap<String, Integer>();
        cmap = new ConcurrentHashMap<String, Integer>();
    }
    public static void main(String[] args) {
        HashMapWork hmw = new HashMapWork();

        hmw.map.put("Oliver", 1);
        hmw.map.put("Person2", 1004);
        hmw.map.put("Person3", 104344);

        int output = hmw.map.get("Oliver");
        System.out.println("The output: " + output);

    }
}
