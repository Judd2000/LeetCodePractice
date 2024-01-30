package splitbyseparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitTest {

    Split test;

    @BeforeEach
    void setUp() {
        test = new Split();
    }

    @Test
    void testSplitWordsBySeparator() {
        // Input: words = ["one.two.three","four.five","six"], separator = "."
        // Output: ["one","two","three","four","five","six"]
        List<String> words = new ArrayList<>(Arrays.asList("one.two.three", "four.five", "six"));
        List<String> expected = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six"));
        List<String> result = test.splitWordsBySeparator(words, '.');
        assertEquals(expected, result);

        // words = ["|||"]
        // separator "|", expected: []
        words = new ArrayList<>(Arrays.asList("|", "|", "|"));
        expected = new ArrayList<>();
        result = test.splitWordsBySeparator(words, '|');
        assertEquals(expected, result);
    }
}
