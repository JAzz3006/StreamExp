package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Employee {
    private final String name;
    private final String department;
    private final int salary;



    public static List<Employee> hireEmployees(){
        return List.of(
                new Employee("Alice", "IT", 90000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "IT", 95000),
                new Employee("Diana", "Finance", 70000),
                new Employee("Eve", "HR", 62000),
                new Employee("Frank", "Finance", 72000)
        );
    }



}
