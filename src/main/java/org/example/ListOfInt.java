package org.example;

import java.util.List;
import java.util.stream.Stream;

public class ListOfInt implements ListBuilder<Integer>{
    @Override
    public List<Integer> listMaker(int length) {
        return Stream.generate(ListBuilder.super::intGenerator).limit(length).toList();
    }
}
