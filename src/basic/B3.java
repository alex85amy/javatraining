package basic;

import java.util.HashMap;

public class B3 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("aa", 3);
        hashMap.put("ss", 3);
        hashMap.put("ff", 3);
        System.out.println(hashMap);
//        System.out.println(hashMap.get("two"));
//        System.out.println(hashMap.get("3"));
//        hashMap.put("two", 4);
//        System.out.println(hashMap.get("two"));
//        System.out.println(hashMap.containsKey("4"));
    }
}
