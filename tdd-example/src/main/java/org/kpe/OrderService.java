package org.kpe;

public class OrderService {

    UserRepo userRepo;

    public OrderService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void createOrder(Order order, User user) {
        OrderValidator validator = new OrderValidator();
        if (validator.isValidOrder(order)) {
            if (userHasEnoughMoney(order, user.getMoney())) {
                new UserService(userRepo).chargeMoney(user, order);
            }
        } else {
            throw new RuntimeException();
        }
    }

//    public boolean createOrder(Order order, User user) {
//        OrderValidator validator = new OrderValidator();
//        if (validator.isValidOrder(order)) {
//            if (userHasEnoughMoney(order, user.getMoney())) {
//                new UserService(userRepo).chargeMoney(user, order);
//                return false;
//            }
//            return true;
//        } else {
//            throw new RuntimeException();
//        }
//    }

    private boolean userHasEnoughMoney(Order order, int money) {
        int productsPrice = order.product().getPrice() * order.count();
        return money > productsPrice;
    }
}
