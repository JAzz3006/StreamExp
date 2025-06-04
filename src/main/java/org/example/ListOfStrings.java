package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListOfStrings implements ListBuilder<String> {
    public static final int MAX_STRING_LENGTH = 3;
    public static final int MIN_STRING_LENGTH = 7;
    @Override
    public List<String> listMaker(int length) {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < length; ++i){
            int currentLength = MIN_STRING_LENGTH +
                    (int) (Math.random() * (MAX_STRING_LENGTH - MIN_STRING_LENGTH));
            strList.add(ListBuilder.super.strGenerator(currentLength));
        }
        return strList;
    }

    public List<String> listMakerAlt (int length){
        return Stream.generate(() -> ListBuilder.super.strGenerator(rndLengthGenerator()))
                .limit(length)
                .toList();
    }

    public int rndLengthGenerator(){
        return MIN_STRING_LENGTH +
                (int) (Math.random() * (MAX_STRING_LENGTH - MIN_STRING_LENGTH));
    }
    public static List<String> listOfStringsGen (){
        return List.of(
                "Пес лежал в воротах сарая - передние лапы вытянуты, уши торчком и глаза",
                "- угли раскаленные: так и сверлят, так и буравят баранью тушку, над  которой",
                "в глубине сарая хлопотал хозяин. Спина и шея у Михаила взмокли:  нет  ничего",
                "хуже обдирать сопревшее межножье да седловину. Кожа тут прикипела  намертво,",
                "каждый сантиметр прорезать надо. А кроме того, мухи, оводы окаянные - поедом",
                "едят, глаза слепят. Зато уж когда все это прошел да миновал подбрюшье - одно",
                "удовольствие: нож  в  балку  над  головой  и  давай-давай  орудовать  одними",
                "руками..."
        );
    }


}
