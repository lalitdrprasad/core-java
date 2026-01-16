package com.study.practice;

import java.util.OptionalInt;

public class NonRepeatingChar {

    public static char firstNonRepeatingChar(String s) {

        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
        OptionalInt first = s.chars()
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c)).findFirst();

        if (first.isPresent()) {
            return (char) first.getAsInt();
        } else {
            return '\0'; // or throw an exception if preferred
        }
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("swiss"));
    }
}
