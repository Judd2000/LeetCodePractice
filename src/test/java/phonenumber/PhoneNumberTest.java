package phonenumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberTest {
    PhoneNumber test;

    @BeforeEach
    void init() {
        test = new PhoneNumber();
    }

    @Test
    void testLetterCombinations() {
        // Input: digits = "23"
        // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        String input = "23";
        List<String> expected = new ArrayList<>(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"));
        assertEquals(expected, test.letterCombinations(input));

        // Input: digits = "2"
        // Output: ["a","b","c"]
        input = "2";
        expected = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertEquals(expected, test.letterCombinations(input));

        // Input: digits = ""
        // Output: []
        input = "";
        expected = new ArrayList<>();
        assertEquals(expected, test.letterCombinations(input));
    }
}
