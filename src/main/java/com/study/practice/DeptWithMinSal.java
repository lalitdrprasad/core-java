package com.study.practice;

import java.util.Comparator;
import java.util.List;

public class DeptWithMinSal {
    public static void main(String[] args) {

        List<Employee1> Employees = List.of(
                new Employee1("Alice", "IT", 70000, 32),
                new Employee1("Bob", "Finance", 85000, 45),
                new Employee1("Charlie", "IT", 60000, 25),
                new Employee1("David", "HR", 90000, 39),
                new Employee1("Eve", "IT", 70000, 41),
                new Employee1("Frank", "Finance", 95000, 52));

        Employees.stream().min(Comparator.comparingDouble(Employee1::getSalary))
                .ifPresent(System.out::println);
    }
}