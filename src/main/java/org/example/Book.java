package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Book {
    private final String title;
    private final List<String> authors;
//    private int year;
//    private double rating;

    private List<Book> biblioGenerator(){
        return List.of(
                new Book("Effective Java", List.of("Joshua Bloch")),
                new Book("Java Concurrency in Practice", List.of("Brian Goetz", "Joshua Bloch")),
                new Book("Clean Code", List.of("Robert C. Martin")),
                new Book("Head First Java", List.of("Kathy Sierra", "Bert Bates"))
        );
    }

}
