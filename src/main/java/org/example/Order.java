package org.example;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Order {
    private static final AtomicInteger counter = new AtomicInteger(123);
    private final int id;
    private final String product;
    private final int price;

    public Order (String product, int price){
        id = counter.incrementAndGet();
        this.product = product;
        this.price = price;
    }
}
