package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Tst5 {
    public static void main(String[] args) {
        List<Article> articles = Article.stringListGenerator();
        TreeSet<String> uniqueWords = articles.stream()
                .flatMap(article -> article.getSentences().stream()
                        .flatMap(el -> Arrays.stream(el.split("\\s+")))
                )
                .map(String::toLowerCase)
                .collect(
                        () -> new TreeSet<>(Comparator.naturalOrder()),
                        TreeSet::add,
                        TreeSet::addAll
                );
        uniqueWords.forEach(System.out::println);

    }
}
