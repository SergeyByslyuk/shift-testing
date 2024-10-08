import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kpe.Customer;
import org.kpe.Product;
import org.kpe.Store;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {
    @Mock
    Store mockStore;

    //classic style testing
    @Test
    public void purchaseSucceedWhenEnoughInventoryByClassicStyle() {
        //arrange
        Store store = new Store();
        Customer customer = new Customer(store);

        //act
        boolean success = customer.purchase(Product.CHEESE, 5);

        //assert
        assertTrue(success);
        assertEquals(store.getInventory(Product.CHEESE), 5);
    }

    //london style testing
    @Test
    public void purchaseSucceedWhenEnoughInventoryByLondonStyle() {
        //arrange

        Customer customer = new Customer(mockStore);
        doNothing().when(mockStore).removeInventory(Product.CHEESE, 5);

        //act
        boolean success = customer.purchase(Product.CHEESE, 5);

        //assert
        assertTrue(success);
        verify(mockStore).removeInventory(Product.CHEESE, 5);
    }
}
