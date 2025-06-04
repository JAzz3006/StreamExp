package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Tst3 {
    public static final int THRESHOLD_SALARY = 70000;
    public static void main(String[] args) {

        List<Employee> payroll = Employee.hireEmployees();
        Map<String, List<Employee>> resultMap = payroll.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator
                                                .comparingInt(Employee::getSalary).reversed()
                                                .thenComparing(Employee::getName)
                                        )
                                        .limit(2)
                                        .collect(Collectors.toList())
                        )
//                        Collectors.toCollection(() -> new TreeSet<Employee>(Comparator
//                                .comparingInt(Employee::getSalary).reversed()
//                                .thenComparing(Employee::getName)))
                ));
//        resultMap.forEach((key, value) -> {
//            System.out.println("Department - " + key);
//            value.forEach(e -> System.out.println(e.getName()
//                    + " - " + e.getSalary() + "$"));
        Map<String, List<String>> groupedPayroll = payroll.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.filtering(
                                e -> e.getSalary() > THRESHOLD_SALARY,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                ))));
//        groupedPayroll.forEach((key, value) -> {
//            System.out.println(key + " Department");
//            value.forEach(System.out::println);
//        });

//        });

    }
}