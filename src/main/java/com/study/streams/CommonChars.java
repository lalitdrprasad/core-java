package com.study.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CommonChars {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "explorer",
                "resort",
                "progesterone",
                "corridor",
                "record",
                "reformation",
                "professor",
                "controller",
                "orchestra",
                "performer"
        );

        System.out.println(sortByLength(words));
        System.out.println("Shortest Word : " + getShortestWord(words));
        System.out.println(findUsingLoop(words));
        System.out.println(findUsingStream(words));
    }

    static String findUsingLoop(List<String> words) {
        StringBuilder result = new StringBuilder();
        for (char ch : getShortestWord(words).toCharArray()) {
            boolean flag = true;
            for (String word : words) {
                if (word.indexOf(ch) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.append(ch);
        }
        return result.toString();
    }

    static String findUsingStream(List<String> words) {
        return words.get(0).chars().
                filter(ch -> words.stream().
                        skip(1).
                        allMatch(str -> str.indexOf(ch) != -1)
                ).mapToObj(Character::toString).collect(Collectors.joining());
    }

    static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    static String getShortestWord(List<String> list) {
        return list.stream().min(Comparator.comparingInt(String::length)).orElseThrow();
    }
}
