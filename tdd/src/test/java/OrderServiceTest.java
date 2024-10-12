import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kpe.Order;
import org.kpe.OrderService;
import org.kpe.Product;
import org.kpe.User;
import org.kpe.UserRepo;
import org.kpe.UserService;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    UserRepo userRepo;


    @Test
    public void refuseOrderIfUserHasNoMoney() {
        UserService userService = new UserService(userRepo);
        OrderService orderService = new OrderService(userService);
        Order order = new Order(Product.TOMATO, 10);
        User user = new User(1, 20);

        orderService.createOrder(order, user);

        verifyNoMoreInteractions(userRepo);

    }

    @Test
    public void throwExceptionIfOrderInvalid() {
        UserService userService = new UserService(userRepo);
        OrderService orderService = new OrderService(userService);
        Order order = new Order(Product.TOMATO, -5);
        User user = new User(1, 20);

        assertThrows(Exception.class, ()->  orderService.createOrder(order, user));
    }

    @Test
    public void moneyIsChargedIfOrderSuccess() {
        //arrange
        UserService userService = new UserService(userRepo);
        OrderService orderService = new OrderService(userService);
        Order order = new Order(Product.TOMATO, 5);
        User user = new User(1, 20);
        doNothing().when(userRepo).updateMoney(5);
        //act
        orderService.createOrder(order, user);
        //assert
        verify(userRepo).updateMoney(5);
    }

}
