package a;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A1 {
    public static Map<String, Integer> countWord(String text) {

        return Arrays.stream(text.split("\\s+|,\\s*|\\.\\s*"))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));// Collectors.counting()回傳Long

    }

    public static TreeMap<String, Integer> sortByValue(Map<String, Integer> map) {
        // 建立新的 TreeMap，設定排序 Comparator
        TreeMap<String, Integer> sortedMap = new TreeMap<>((o1, o2) -> {
            int valueCompare = map.get(o2).compareTo(map.get(o1)); // 按 value 降序排序
            // value 相同則比較自然序
            if (valueCompare == 0) {
                return o1.compareTo(o2);
            }
            return valueCompare;
        });
        sortedMap.putAll(map); // 將 map 放入 TreeMap
        return sortedMap;
    }

    public static LinkedHashMap<String, Integer> sortByValue2(Map<String, Integer> map) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        // 建立 LinkedHashMap 後，用 stream 比較 value 排序放入
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }

    public static void main(String[] args) {

        String str = "This is a book. That is a pencil.This is good, and that is bad. ";
        Map<String, Integer> wordMap = countWord(str);
        TreeMap<String, Integer> sortedWordList = sortByValue(wordMap);
//        LinkedHashMap<String, Integer> sortedWordList = sortByValue2(wordMap);
        sortedWordList.forEach((word, frequency) -> {
            String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            System.out.println(capitalizedWord + ": " + frequency);
        });
    }
}
