package jewelsandstones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JewelsAndStonesTest {
    JewelsAndStones test;

    @BeforeEach
    void init() {
        test = new JewelsAndStones();
    }

    @Test
    void testNumJewelsInStones() {
        // Input: jewels = "aA", stones = "aAAbbbb"
        // Output: 3
        String jewels = "aA";
        String stones = "aAAbbbb";

        int expected = 3;
        assertEquals(expected, test.numJewelsInStones(jewels, stones));

        // Input: jewels = "z", stones = "ZZ"
        // Output: 0
        jewels = "z";
        stones = "ZZ";

        expected = 0;
        assertEquals(expected, test.numJewelsInStones(jewels, stones));
    }
}
