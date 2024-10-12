package org.kpe;

public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void chargeMoney(User user, Order order) {

        int updateMoney = user.getMoney() - (order.product().getPrice() * order.count());
        userRepo.updateMoney(updateMoney);
    }
}
