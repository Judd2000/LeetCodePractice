package happynumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    @Test
    @DisplayName("Testing valid happy numbers...")
    void testIsHappy() {
        assertTrue(HappyNumber.isHappy(19));
        assertTrue(HappyNumber.isHappyFloydsAlgorithm(19));
        assertTrue(HappyNumber.isHappy(86));
        assertTrue(HappyNumber.isHappyFloydsAlgorithm(86));
        assertTrue(HappyNumber.isHappy(32));
        assertTrue(HappyNumber.isHappyFloydsAlgorithm(32));
        assertTrue(HappyNumber.isHappy(331));
        assertTrue(HappyNumber.isHappyFloydsAlgorithm(331));
        assertTrue(HappyNumber.isHappy(262));
        assertTrue(HappyNumber.isHappyFloydsAlgorithm(262));
        assertTrue(HappyNumber.isHappy(263));
        assertTrue(HappyNumber.isHappyFloydsAlgorithm(263));
    }

    @Nested
    @DisplayName("Test that non-valid happy numbers don't loop for very long")
    class noTimeoutTests {

        @Test
        void testFirst() {
            assertTimeoutPreemptively(Duration.ofSeconds(1), () -> assertFalse(HappyNumber.isHappy(332)));
            assertTimeoutPreemptively(Duration.ofSeconds(1), () -> assertFalse(HappyNumber.isHappyFloydsAlgorithm(332)));
        }

        @Test
        @Timeout(value = 1)
        void testSecond() {
            assertTimeoutPreemptively(Duration.ofSeconds(1), () -> assertFalse(HappyNumber.isHappy(264)));
            assertTimeoutPreemptively(Duration.ofSeconds(1), () -> assertFalse(HappyNumber.isHappyFloydsAlgorithm(264)));
        }

        @Test
        @Timeout(value = 1)
        void testThird() {
            assertTimeoutPreemptively(Duration.ofSeconds(1), () -> assertFalse(HappyNumber.isHappy(3)));
            assertTimeoutPreemptively(Duration.ofSeconds(1), () -> assertFalse(HappyNumber.isHappyFloydsAlgorithm(3)));
        }
    }
}
