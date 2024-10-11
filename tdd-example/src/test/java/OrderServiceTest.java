import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kpe.Order;
import org.kpe.OrderService;
import org.kpe.Product;
import org.kpe.User;
import org.kpe.UserRepo;
import org.kpe.UserRepoImpl;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    UserRepoImpl userRepo;

//    @Test
//    public void createSucceedOrder() {
//
//        OrderService orderService = new OrderService(userRepo);
//        Order order = new Order(Product.TOMATO, 5);
//        User user = new User(1, 20);
//
//        orderService.createOrder(order, user);
//
//        assertTrue(expectedStatus);
//    }

    @Test
    public void refuseOrderIfUserHasNotEnoughMoney() {

        OrderService orderService = new OrderService(userRepo);
        Order order = new Order(Product.POTATO, 5);
        User user = new User(1, 20);

        orderService.createOrder(order, user);

        verifyNoMoreInteractions(userRepo);

    }

    @Test
    public void throwExceptionIfOrderIsInvalid() {

        OrderService orderService = new OrderService(userRepo);
        Order order = new Order(Product.POTATO, -5);
        User user = new User(1, 20);

        assertThrows(Exception.class, () -> orderService.createOrder(order, user));
    }

    @Test
    public void moneyIsChargedIfOrderSuccess() {

        OrderService orderService = new OrderService(userRepo);
        Order order = new Order(Product.TOMATO, 5);
        User user = new User(1, 20);
        doNothing().when(userRepo).updateMoney(5);

        orderService.createOrder(order, user);

        verify(userRepo).updateMoney(5);
//        assertEquals(5, user.getMoney());
    }


}
