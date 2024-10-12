package org.kpe;

public enum Product {

    TOMATO(3),
    POTATO(5);

    private final int price;
    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
