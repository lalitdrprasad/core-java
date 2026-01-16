package com.study.java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WaysToCreateStream {
    public static void main(String[] args) {
        // 1. From a Collection
        Stream<String> streamFromCollection = java.util.Arrays.asList("a", "b", "c").stream();
        streamFromCollection.forEach(System.out::println);

        // 2. From an Array
        Stream<Integer> streamFromArray = java.util.Arrays.stream(new Integer[]{1, 2, 3});
        streamFromArray.forEach(System.out::println);

        // 3. Using Stream.of()
        Stream<Double> streamOf = Stream.of(1.1, 2.2, 3.3);
        streamOf.forEach(System.out::println);

        // 4. Using Stream.generate()
        Stream<Double> generatedStream = Stream.generate(Math::random).limit(5);
        generatedStream.forEach(System.out::println);

        // 5. Using Stream.iterate()
        Stream<Integer> iteratedStream = Stream.iterate(0, n -> n + 2).limit(5);
        iteratedStream.forEach(System.out::println);

        // 6. From a String (chars)
        Stream<Integer> charStream = "hello".chars().boxed();
        charStream.forEach(System.out::println);

    }
}