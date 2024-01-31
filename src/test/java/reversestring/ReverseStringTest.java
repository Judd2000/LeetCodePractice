package reversestring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseStringTest {
    ReverseString test;

    @BeforeEach
    void setUp() {
        this.test = new ReverseString();
    }

    @Test
    void testReverseString() {
        // Input: s = ["h","e","l","l","o"]
        // Output: ["o","l","l","e","h"]
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] expected = new char[]{'o', 'l', 'l', 'e', 'h'};
        this.test.reverseString(input);
        assertArrayEquals(input, expected);

        // Input: ["H","a","n","n","a","h"]
        // Output: ["h","a","n","n","a","H"]
        input = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        expected = new char[]{'h', 'a', 'n', 'n', 'a', 'H'};
        this.test.reverseString(input);
        assertArrayEquals(input, expected);
    }
}
