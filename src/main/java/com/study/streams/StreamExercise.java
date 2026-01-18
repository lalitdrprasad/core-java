package com.study.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExercise {

    private static final List<String> list = Arrays.asList("ABC", "pineapple", "pineapple", "strawberry", "strawberry", "blueberry", "blueberry", "chimpanzee", "eggs", "chilly", "chimpanzee", "orangutan", "orangutan", "pomegranate", "watermelon", "blackberry", "raspberry", "butterfly");
    private static final List<Employee> itEmployees = Arrays.asList(new Employee(101, "Amit", "IT", 75000), new Employee(102, "Rahul", "IT", 90000), new Employee(103, "Sneha", "IT", 82000));
    private static final List<Employee> financeEmployees = Arrays.asList(new Employee(201, "Anita", "Finance", 88000), new Employee(202, "Vikram", "Finance", 95000), new Employee(203, "Meera", "Finance", 91000));
    private static final List<Employee> hrEmployees = Arrays.asList(new Employee(301, "Neha", "HR", 65000), new Employee(302, "Pooja", "HR", 70000), new Employee(303, "Rakesh", "HR", 68000));

    public static void main(String[] args) {
        removeDuplicate();
        ifWordPresentInList("strawberry");
        ifWordPresentInList("straw");
        countOccurrence("pineapple");
        countOccurrence("pineapples");
        wordFrequencyMap();
        printWordsAppearingExactlyNTimes(2);
        groupWordsByLength();
        firstNonRepeatingWord();
        wordWithMaxDistinctCharacters();
        allNonRepeatingCharsAfterMergingAllWords();
        sortUniqueWordsByLastCharacter();
        charsInOrderWord();
        arithmeticOperations();
        sumOfSalaryByDept();
        System.out.println(combineAllEmployees());
        maxAverageSalaryByDept();
        sortEmployeesBySalary();
        sortEmployeesBySalaryWithoutSorted();
    }

    private static void sortEmployeesBySalaryWithoutSorted() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.sortEmployeesBySalaryWithoutSorted");

        TreeSet<Employee> collect = combineAllEmployees().stream()
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Employee::salary))));
        collect.forEach(System.out::println);
    }

    private static void sortEmployeesBySalary() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.sortEmployeesBySalary");

        combineAllEmployees().stream().sorted(Comparator.comparingDouble(Employee::salary).reversed()).forEach(System.out::println);
    }

    private static void maxAverageSalaryByDept() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.sumOfSalaryByDept");
        List<Employee> employees = combineAllEmployees();

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department,
                                Collectors.averagingDouble(Employee::salary)
                        ));

        Map.Entry<String, Double> aveHighestSalEntry = avgSalaryByDept.entrySet().
                stream().max(Map.Entry.comparingByValue()).orElseThrow();

        System.out.println(aveHighestSalEntry.getKey() + " : " + aveHighestSalEntry.getValue());
    }

    private static List<Employee> combineAllEmployees() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.combineAllEmployees");
        List<List<Employee>> listOfListOfEmployees = Arrays.asList(itEmployees, financeEmployees, hrEmployees);
        return listOfListOfEmployees.stream().flatMap(Collection::stream).toList();

    }

    private static void sumOfSalaryByDept() {
        System.out.println("================================================================");

    }

    private static void arithmeticOperations() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.arithmeticOperations");
        List<Integer> integerList = Arrays.asList(14, 3, 39, 18, 36, 14, 84, 24, 87, 45, 1, 16, 71, 54, 22, 79, 64, 40, 84, 28, 56, 76, 24);
        System.out.println("Sum : " + integerList.stream().reduce(Integer::sum).orElse(0));
        System.out.println("Min on Integer: " + integerList.stream().min(Integer::compare).orElse(0));
        System.out.println("Max on Integer: " + integerList.stream().max(Integer::compare).orElse(0));
        System.out.println("Min on int: " + integerList.stream().mapToInt(i -> i).min().orElse(0));
        System.out.println("Max on int: " + integerList.stream().mapToInt(i -> i).max().orElse(0));
        System.out.println("Average : " + integerList.stream().mapToInt(i -> i).average().orElse(0));
        System.out.println("Sum Of Square : " + integerList.stream().map(num -> num * num).reduce(Integer::sum).orElse(0));
        System.out.println("Sum Of Even : " + integerList.stream().filter(num -> num % 2 == 0).reduce(Integer::sum).orElse(0));
        System.out.println("Sum Of Odd : " + integerList.stream().filter(num -> num % 2 == 1).reduce(Integer::sum).orElse(0));
        System.out.println("Sorted : " + integerList.stream().sorted().toList());
        System.out.println("5th Highest Number : " + integerList.stream().sorted().skip(4).findFirst().orElseThrow());
    }

    private static void charsInOrderWord() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.charsInOrderWord");

        list.stream().
                filter(word -> word
                        .chars().sorted()
                        .mapToObj(Character::toString).
                        collect(Collectors.joining()).equals(word))
                .forEach(System.out::println);
    }

    private static void sortUniqueWordsByLastCharacter() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.sortUniqueWordsByLastCharacter");
        list.stream()
                .distinct()
                .filter(word -> Collections.frequency(list, word) == 1)
                .sorted(Comparator.comparingInt(word -> word.charAt(word.length() - 1)))
                .forEach(System.out::println);
    }

    private static void allNonRepeatingCharsAfterMergingAllWords() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.printAllNonRepeatingCharacterInSingleString");
        int[] freq = new int[256];
        list.forEach(word -> word.chars().forEach(ch -> freq[ch]++));
        String allNonRepeatingChars =
                list.stream()
                        .flatMapToInt(String::chars)
                        .filter(ch -> freq[ch] == 1)
                        .mapToObj(ch -> Character.toString((char) ch))
                        .collect(Collectors.joining());
        System.out.println(allNonRepeatingChars);
    }

    private static void wordWithMaxDistinctCharacters() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.wordWithMaxDistinctCharacters");
        Optional<String> max = list.stream().map(word -> word.chars().distinct().mapToObj(Character::toString).collect(Collectors.joining())).
                max(Comparator.comparingInt(String::length));

        System.out.println(max.orElse("Empty List"));
    }

    private static void groupWordsByLength() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.groupWordsByLength");
        HashMap<Integer, List<String>> groupedWordsByLength = new HashMap<>();
        list.forEach(word -> groupedWordsByLength.merge(
                word.length(), new ArrayList<>(List.of(word)),
                (existingList, newList) -> {
                    existingList.addAll(newList);
                    return existingList;
                })
        );
        groupedWordsByLength.forEach((key, value) -> System.out.println("Words with length: " + key + " - " + value));
    }

    static void ifWordPresentInList(String word) {
        System.out.println("================================================================");
        System.out.println("StreamExercise.ifWordPresentInList: " + word);
        System.out.println(list.stream().anyMatch(str -> str.equals(word)));
    }

    static void removeDuplicate() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.removeDuplicate");
        System.out.println(list.stream().distinct().toList());
        System.out.println("Count after removing duplicates: " + list.stream().distinct().count());
    }

    private static void countOccurrence(String word) {
        System.out.println("================================================================");
        System.out.println("StreamExercise.countOccurrence: " + word);
        System.out.println(list.stream().filter(str -> str.equals(word)).count());
    }

    private static void wordFrequencyMap() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.wordFrequencyMap");
        Map<String, Long> wordFrequency =
                list.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));

        wordFrequency.forEach((k, v) -> System.out.println(k + " - " + v));

        //Or

        Map<String, Long> wordFrequency1 = new HashMap<>();
        list.forEach(word -> wordFrequency1.merge(" " + word, 1L, Long::sum));
        wordFrequency1.entrySet().forEach(System.out::println);
    }


    private static void printWordsAppearingExactlyNTimes(int n) {
        System.out.println("================================================================");
        System.out.println("StreamExercise.printWordsAppearingExactlyNTimes");
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        list.forEach(word -> wordFrequency.merge(word, 1, Integer::sum));
        List<String> wordsAppearingExactlyNTimes = wordFrequency.entrySet().stream().filter(entry -> entry.getValue() == n).map(Map.Entry::getKey).toList();
        System.out.println(wordsAppearingExactlyNTimes); //This can also be used to count the frequency of each word using stream

        /*  int frequency = Collections.frequency(list, "pineapple"); */
    }

    private static void firstNonRepeatingWord() {
        System.out.println("================================================================");
        System.out.println("StreamExercise.firstNonRepeatingWord");
        Optional<String> firstOne = list.stream().filter(word -> Collections.frequency(list, word) == 1).findFirst();
        System.out.println(firstOne.orElse("All words are duplicate"));
    }
}
