package org.example;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ListBuilder<E> {
    public static final int MIN_CHAR_CODE = 33;
    public static final  int MAX_CHAR_CODE = 127;
    List<E> listMaker (E e);

    default String strGenerator(int length){
        char[] charArray = new char[length];
        for (int i = 0; i < length; ++i){
            int currCode = MIN_CHAR_CODE +
                    (int) Math.round(Math.random() *
                            (MAX_CHAR_CODE - MIN_CHAR_CODE));
            charArray[i] = (char) currCode;
        }
        return new String(charArray);
    }


}

