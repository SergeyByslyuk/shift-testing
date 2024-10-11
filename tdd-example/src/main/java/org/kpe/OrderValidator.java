package org.kpe;

public class OrderValidator {

    public boolean isValidOrder(Order order) {
        return order.count() > 0;
    }
}
