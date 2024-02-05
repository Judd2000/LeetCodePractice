package clockangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockAngleTest {
    ClockAngle test;
    @BeforeEach
    void init() {
        test = new ClockAngle();
    }

    @Test
    void testAngleClock() {
        // Input : hour = 12, minutes = 30;
        // Output: 165
        int hours = 12;
        int mins = 30;

        double expected = 165;
        assertEquals(expected, test.angleClock(hours, mins));

        // Input: hour = 1, minutes = 57
        // Output: 76.500000
        hours = 1;
        mins = 57;

        expected = 76.5;
        assertEquals(expected, test.angleClock(hours, mins));
    }
}
