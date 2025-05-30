package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private String city;
    private int age;

    public static List<User> userListBuilder(){
        return List.of(
                new User("Alice", "Berlin", 30),
                new User("Bob", "Paris", 25),
                new User("Jlob", "Paris", 35),
                new User("Aybob", "Paris", 45),
                new User("Charlie", "Berlin", 40),
                new User("David", "Paris", 35),
                new User("Eve", "Berlin", 28),
                new User("Frank", "London", 33)
        );
    }
}
