package uglynumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UglyNumberTest {
    @Test
    void testIsUgly() {
        assertAll(
                () -> assertTrue(UglyNumber.isUgly(6)),
                () -> assertTrue(UglyNumber.isUgly(1)),
                () -> assertFalse(UglyNumber.isUgly(14))
        );
    }
}
