package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tst1 {
    public static void main(String[] args) {

        List<User> list = User.userListBuilder();

        Map<String, List<String>> result = list.stream()
                .filter(u -> u.getAge() > 30)
                .collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.mapping(User::getName, Collectors.collectingAndThen(
                                Collectors.toList(), s -> {
                                    s.sort(Comparator.naturalOrder());
                                    return s;
                                }))));

        result.forEach((key, value) -> System.out.println(key + " - " + value));



    }
}
