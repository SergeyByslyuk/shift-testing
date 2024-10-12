package org.kpe;

public class OrderValidator {

    public static boolean isValid(Order order) {
        return order.count() > 0;
    }
}
