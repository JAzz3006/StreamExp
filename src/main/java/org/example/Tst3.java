package org.example;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Tst3 {
    public static void main(String[] args) {

        List<Employee> payroll = Employee.hireEmployees();
        Map<String, List<String>> resultMap = payroll.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.mapping(
                                e -> e.getName() + "(" + e.getSalary() + "$)",
                                Collectors.toList())
                ));
        resultMap.forEach((key, value) -> System.out.println(key + " - " + value));

    }
}