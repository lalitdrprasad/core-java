package com.study.streams;

import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String input = "programming";

        String result = input.
                chars().
                distinct().
                mapToObj(Character::toString).
                collect(Collectors.joining());

        System.out.println(result);

    }

}
