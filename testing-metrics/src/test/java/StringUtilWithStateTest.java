import org.junit.jupiter.api.Test;
import org.kpe.StringUtilsWithState;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringUtilWithStateTest {

    @Test
    public void stringIsNotLong() {
        boolean isLong = StringUtilsWithState.isStringLong("123");
        assertFalse(isLong);
    }
}
