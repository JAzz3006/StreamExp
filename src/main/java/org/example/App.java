package org.example;

import java.sql.Array;

public class App{
    public static final int MIN_CHAR_CODE = 33;
    public static final  int MAX_CHAR_CODE = 127;

    public static void main(String[] args )
    {
        System.out.println(ListBuilder.MAX_CHAR_CODE);
    }
    public static String strGenerator(int length){
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
