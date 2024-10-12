package org.kpe;

public class OrderService {

    UserService userService;
    public OrderService(UserService userService) {
        this.userService = userService;

    }

    public void createOrder(Order order, User user) {

        if (OrderValidator.isValid(order)) {
            handleUserMoney(order, user);
        } else {
            throw new IllegalArgumentException();
        }

    }

    private void handleUserMoney(Order order, User user) {
        if (userHasEnoughMoney(order, user)) {
            userService.chargeMoney(user, order);
        }
    }

    private static boolean userHasEnoughMoney(Order order, User user) {
        return user.getMoney() >= order.count() * order.product().getPrice();
    }
}
