package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tst4 {
    public static void main(String[] args) {
        List<User> users = User.userListBuilder();
        //задача №5
        Map<Character, List<String>> experimentalList = users.stream()
                .filter(user -> user.getAge() < 39 && user.getAge() > 20)
                .map(user -> user.getName() + " - " + user.getAge())
                .collect(Collectors.groupingBy(
                        s -> s.charAt(0)
                ));
        //experimentalList.forEach((key, value) -> System.out.println(key + " - " + value));



        //задача №4
        Map<Integer, List<String>> superMap = users.stream()
                .collect(Collectors.filtering(
                        user -> user.getAge() < 30,
                        Collectors.flatMapping(
                                user -> user.getOrders().stream(),
                                Collectors.groupingBy(
                                        Order::getPrice,
                                        () -> new TreeMap<>(Comparator.reverseOrder()),
                                        Collectors.mapping(
                                                order -> order.getProduct() + " (Id = " + order.getId() + ")",
                                                Collectors.toList()
                                        )
                                )
                        )
                        )
                );
        //superMap.forEach((k, v) -> System.out.println(k + " - " + v));



        //задача №3
        Set<String> products = users.stream()
                .flatMap(user -> user.getOrders().stream())
                .map(Order::getProduct)
                .collect(Collectors.toCollection(
                        LinkedHashSet::new
                        )
                );
        Map<Character, List<String>> groupedByFirstLetter = products.stream()
                .collect(Collectors.groupingBy(
                        s -> s.charAt(0),
                        TreeMap::new,
                        Collectors.toList()
                ));
        //groupedByFirstLetter.forEach((k, v) -> System.out.println(k + " - " + v));

        //задача №1
        //так создаем Компаратор
        Comparator<Order> orderPriceComparator = Comparator
                .comparingInt(Order::getPrice)
                .thenComparing(Order::getProduct)
                .thenComparing(Order::getId);

        Optional<Order> order = users.stream()
                .flatMap(user -> user.getOrders().stream())
                .max(orderPriceComparator);
        if (order.isPresent()){
            System.out.println(order.get().getPrice() + " - " + order.get().getProduct());
        }else System.out.println("It's empty");



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
