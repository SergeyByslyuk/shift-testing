import org.junit.jupiter.api.Test;
import org.kpe.ExternalStringUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

//пример того, что branch coverage показывает 100% покрытия,
// хотя можно придумать аргументы методов, когда код упадет
public class ExternalStringUtilTest {

    @Test
    public void successParseInt() {
        int result = ExternalStringUtil.isStringLong("123");

        assertEquals(result, 123);
    }
}
