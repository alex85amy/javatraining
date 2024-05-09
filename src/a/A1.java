package a;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A1 {
    public static Map<String, Integer> countWord(String text) {

        return Arrays.stream(text.split("\\s+|,\\s*|\\.\\s*"))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));// Collectors.counting()回傳Long

    }

    public static LinkedHashMap<String, Integer> sortByValue(Map<String, Integer> map) {
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
        LinkedHashMap<String, Integer> sortedWordList = sortByValue(wordMap);

        sortedWordList.forEach((word, frequency) -> {
            String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            System.out.println(capitalizedWord + ": " + frequency);
        });
    }
}
