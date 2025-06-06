package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String city;
    private int age;
    private List<Order> orders;

    public User(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }


    public static List<User> userListBuilder(){
        return List.of(
                new User("Alice", "Berlin", 30,
                        List.of(new Order("Squirrel", 55),
                                new Order("Whistle", 25))),
                new User("Bob", "Paris", 25,
                        List.of(new Order("Meat and ketchup", 234),
                                new Order("Set of forks", 130))),
                new User("Jlob", "Paris", 35,
                        List.of(new Order("Pandora's box", 500))),
                new User("Aybob", "Paris", 45,
                        List.of(new Order("Jam and spoon", 80),
                                new Order("Guns and roses", 640),
                                new Order("Simon and Garfunkel", 560))),
                new User("Charlie", "Berlin", 40,
                        List.of(new Order("Bath", 20),
                                new Order("Coffee", 30),
                                new Order("Cacao and tea", 580))),
                new User("David", "Paris", 35,
                        List.of(new Order("Marmalade", 50),
                                new Order("Sugar", 90))),
                new User("Eve", "Berlin", 28,
                        List.of(new Order("milk and honey", 20),
                                new Order("Toast", 12),
                                new Order("Honey", 50))),
                new User("Frank", "London", 33,
                        List.of(new Order("Cap", 40),
                                new Order("Donkey turds", 25),
                                new Order("Simon and Garfunkel", 640)))
        );
    }

}
