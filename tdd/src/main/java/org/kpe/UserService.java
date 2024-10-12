package org.kpe;

public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void chargeMoney(User user, Order order) {
        int money = user.getMoney() - (order.count() * order.product().getPrice());
        userRepo.updateMoney(money);
    }
}
