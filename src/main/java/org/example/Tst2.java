package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Tst2 {
    public static final List<String> VOWELS_LIST = List.of("a", "e", "i", "o", "u", "y");
    public static void main(String[] args) {
        //начало задачи на флатмап №4
        List<String> sentences = List.of(
                "Java is cool",
                "Streams are powerful in Java",
                "Java and flatMap are amazing"
        );
        TreeSet<String> wordSet = sentences.stream()
                .map(String::toLowerCase)
                .flatMap(a -> Arrays.stream(a.split("\\s+")))
                //.distinct()
                .collect(TreeSet::new,
                        TreeSet::add,
                        TreeSet::addAll
                );
        System.out.println(wordSet);

        //конец задачи на флатмап №4
        //начало задачи на флатмап №3
        List<String> linez = List.of(
                "Order #1234: 3 items",
                "Invoice 567 and 89",
                "No digits here!",
                "Final code: 42"
        );
        List<String> digits = linez.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .filter(s -> Character.isDigit(s.charAt(0)))
                .toList();
        //System.out.println(digits);
        //конец задачи на флатмап №3

        //начало задачи на флатмап №2
        List<List<String>> wordGroups = List.of(
                List.of("elephant", "tiger"),
                List.of("cat", "dog", "mouse"),
                List.of("hippo"),
                List.of("giraffe", "lion", "goat")
        );
        List<String> splitList = wordGroups.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .toList();
        //splitList.forEach(System.out::println);
        //конец задачи на флатмап №2
        //начало задачи про разворот перечня из слов
        List<String> phrases = List.of(
                "elephant and tiger",
                "cat dog mouse",
                "hippo",
                "giraffe lion goat"
        );
        List<String> splitted = phrases.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .toList();
        //splitted.forEach(System.out::println);
        //конец задачи про разворот перечня из слов

        //начало задачи про группировку слов
        List<String> words1 = List.of(
                "badmotherfcuker", "cat", "dog", "elephant", "tiger", "hippo", "giraffe", "lion", "goat", "mouse", "ant"
        );
        Map<Integer, List<String>> wordsMap = words1.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toList()
                ));
        //wordsMap.forEach((key, value) -> System.out.println(key + " - " + value));
        //конец задачи про группировку слов

        //начало задачи по максимум гласных
        List<String> words = List.of("elephant", "dog", "hippopotamus", "cat", "exquisite giraffe", "this string contains maximum vowels");
        Optional <String> optionalMaxVowels = words.stream()
                .map(String::toLowerCase)
                .reduce((a, b) -> vowelsCount(a) > vowelsCount(b)
                        ? a : b);
        String result = optionalMaxVowels.orElse("Поток пустой");
        //System.out.println(result);
        //конец задачи про макисмум гласных

        //начало задачи про длины слов в фразе
        List<Integer> lengthList = words.stream()
                .map(String::toLowerCase)
                .map(String::length)
                .toList();
        //lengthList.forEach(System.out::println);
        //конец задачи про макисмум гласных

        //начало задачи про слова в строчках текста
        List<String> lines = List.of(
                "Elephant in the jungle",
                "Dog",
                "Hippopotamus loves muddy water",
                "Cat",
                "Exquisite giraffe",
                "This string contains the maximum number of vowels and words"
        );
        Optional<String> theLongestOptional = lines.stream()
                .map(String::toLowerCase)
                .reduce((a,b) -> lineSplitter(a) > lineSplitter(b) ? a : b);
        //System.out.println(theLongestOptional.orElse("На входе пусто!"));
        //конец задачи про слова в строчках текста
    }

    public static int vowelsCount(String s){
        String[] letters = s.trim().split("");
        long result = Arrays.stream(letters)
                .filter(VOWELS_LIST::contains)
                .count();
        return (int) result;
    }

    public static int lineSplitter(String s){
        return s.split("\\s+").length;
    }
}

