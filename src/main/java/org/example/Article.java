package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Article {
    private String title;
    private List<String> sentences;

    public static List<Article> stringListGenerator(){
        return List.of(
                new Article("Java", List.of("Java is a language", "Streams are powerful")),
                new Article("Python", List.of("Python is versatile", "Python is readable"))
        );
    }

}
