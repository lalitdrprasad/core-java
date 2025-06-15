package com.study.serialization;
import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = -5557010830816017787L;

    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    private Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.department = builder.department;
        this.salary = builder.salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public static class Builder {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

