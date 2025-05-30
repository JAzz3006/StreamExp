package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App{

    public static void main(String[] args ){
        List<Book> books = List.of(
            new Book("Dune", "Frank Herbert", 1965, 4.8),
            new Book("1984", "George Orwell", 1949, 4.6),
            new Book("Animal farm", "George Orwell", 1953, 4.6),
            new Book("Brave New World", "Aldous Huxley", 1932, 4.3),
            new Book("Foundation", "Isaac Asimov", 1951, 4.7),
            new Book("The end of eternity", "Isaac Asimov", 1951, 4.7),
            new Book("Neuromancer", "William Gibson", 1984, 4.1)
        );

        Map<String, List<String>> result = books.stream()
                .filter(book -> book.getRating() > 4.5d)
                .collect(Collectors.groupingBy(
                        Book::getAuthor,
                        Collectors.mapping(Book::getTitle, Collectors.toList())));

        result.forEach((key, value) -> System.out.println(key + " - " + value));

        Stream<String> words = Stream.of("a", "b", "c", "aa");
        List<String> listOfStrings = words.collect(ArrayList::new, List::add, List::addAll);
        Optional<String> all = listOfStrings.stream().reduce((st1, st2) -> st1 + st2);
        if (all.isPresent()) {
            System.out.println(all.get());;
        }else {
            System.out.println("empty!");
        }
        String w = "whatever";
        w.chars()
                .map(c -> c + 1)
                .collect(Collectors.toList());


    }

    public static String capitalizer (String input){
        input = input.trim();
        return input.substring(0,1).toUpperCase() + input.substring(1);
    }

}
