package org.kpe;

public class OrderValidator {

    public boolean isValid(Order order) {
        return order.count() > 0;
    }
}
