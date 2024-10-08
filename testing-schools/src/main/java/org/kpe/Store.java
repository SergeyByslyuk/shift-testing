package org.kpe;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private final Map<Product, Integer> products = new HashMap<>();

    public Store() {
        products.put(Product.CHEESE, 10);
    }

    public void addInventory(Product product, int count) {
        products.put(product, count);

    }

    public int getInventory(Product product) {
        return products.get(product);
    }

    public void removeInventory(Product product, int count) {
        int currentProducts = getInventory(product);
        if (currentProducts < count) {
            throw new RuntimeException("There's not enough food in the store");
        }
        addInventory(product, currentProducts - count);
    }
}
