package org.example;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ListBuilder<E> {
    int MIN_CHAR_CODE = 65;
    int MAX_CHAR_CODE = 122;
    int MIN_NO_LETTER_CODE = 91;
    int MAX_NO_LETTER_CODE = 97;
    List<E> listMaker (int i);

    default String strGenerator(int length){
        char[] charArray = new char[length];
        for (int i = 0; i < length; ++i){
            charArray[i] = (char) codeGenerator();
        }
        return new String(charArray);
    }

    default int intGenerator(){
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    default int codeGenerator(){
        int currCode = MIN_CHAR_CODE
                + (int) Math.round(Math.random()
                * (MAX_CHAR_CODE - MIN_CHAR_CODE));
        return currCode
                + (MAX_NO_LETTER_CODE - MIN_NO_LETTER_CODE)
                * (currCode / MIN_NO_LETTER_CODE)
                - (MAX_NO_LETTER_CODE - MIN_NO_LETTER_CODE)
                * (currCode / (MAX_CHAR_CODE - (MAX_NO_LETTER_CODE - MIN_NO_LETTER_CODE)));
    }


}

