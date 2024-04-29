package a;

import java.util.*;

public class A1 {
    public static void main(String[] args) {
        String str = "This is a book. That is a pencil.This is good, and that is bad. ";
        Map<String, Integer> wordMap = countWord(str);
        List<Map.Entry<String, Integer>> sortedWordList = sortByValue(wordMap);

        for (Map.Entry<String, Integer> entry : sortedWordList) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            // 將單字的首字母大寫，其他字母小寫
            String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            System.out.println(capitalizedWord + ": " + frequency);
        }
    }

    public static Map<String, Integer> countWord(String text) {
        Map<String, Integer> wordMap = new HashMap<>();
        // 將字串分割成單字數組
        String[] words = text.split("\\s+|,\\s*|\\.\\s*");
        // 統計每個單字的出現次數
        for (String word : words) {
            if (!word.isEmpty()) {
                String lowercaseWord = word.toLowerCase();
                wordMap.put(lowercaseWord, wordMap.getOrDefault(lowercaseWord, 0) + 1);
            }
        }
        return wordMap;
    }

    public static List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 使用Comparator對Map.Entry進行排序，依照value降序排序
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }
}
