package org.kpe;

public class Customer {

    private final Store store;
    public Customer(Store store) {
        this.store = store;
    }

    public boolean purchase(Product product, int count) {
        try {
            store.removeInventory(product, count);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
