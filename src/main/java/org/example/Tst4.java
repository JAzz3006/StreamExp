package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Tst4 {
    public static void main(String[] args) {
        List<User> users = User.userListBuilder();
        //задача №3
        Set<String> products = users.stream()
                .flatMap(user -> user.getOrders().stream())
                .map(Order::getProduct)
                .collect(Collectors.toCollection(
                        TreeSet::new
                        )
                );
        products.forEach(System.out::println);

        //задача №1
        //так создаем Компаратор
        Comparator<Order> orderPriceComparator = Comparator
                .comparingInt(Order::getPrice)
                .thenComparing(Order::getProduct)
                .thenComparing(Order::getId);

        Set<Order> orders = users.stream()
                .flatMap(user -> user.getOrders().stream())
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(orderPriceComparator) //так передаем Компаратор в коллекцию
                ));
//        orders.forEach(System.out::println);
        // Задача №2
        Map<String, List<Order>> groupedByUser = users.stream()
                .collect(Collectors.groupingBy(
                        User::getName,
                        () -> new TreeMap<>(Comparator.reverseOrder()), //сюда не надо совать кастомный Компаратор,
                                                                // это компаратор ДЛЯ КЛЮЧЕЙ !!! только встроенные опции типа как здесь
                        Collectors.flatMapping(f -> f.getOrders().stream(),
                                Collectors.toList())
                ));
       // groupedByUser.forEach((k, v) -> System.out.println(k + " - " + v));
    }


}
