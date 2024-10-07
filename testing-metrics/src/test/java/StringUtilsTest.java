import org.junit.jupiter.api.Test;
import org.kpe.StringUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @Test
    public void stringIsNotLong() {
        boolean isLong = StringUtils.isStringLong("123");

        assertFalse(isLong);
    }

//    @Test
//    public void stringIsLong() {
//        boolean isLong = StringUtils.isStringLong("123456");
//
//        assertTrue(isLong);
//    }
}
