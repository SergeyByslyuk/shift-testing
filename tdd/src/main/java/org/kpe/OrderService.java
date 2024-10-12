package org.kpe;

public class OrderService {
    UserRepo userRepo;
    public OrderService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void createOrder(Order order, User user) {
        OrderValidator orderValidator = new OrderValidator();

        if (orderValidator.isValid(order)) {
            if(userHasEnoughMoney(order, user)) {
                UserService userService = new UserService(userRepo);
                userService.chargeMoney(user, order);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean userHasEnoughMoney(Order order, User user) {
        return user.getMoney() > order.count() * order.product().getPrice();
    }
}
