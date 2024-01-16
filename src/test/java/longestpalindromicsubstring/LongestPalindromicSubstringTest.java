package longestpalindromicsubstring;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LongestPalindromicSubstringTest {
    @Test
    void testLongestPalindrome() {
        assertThrows(InvalidParameterException.class, () -> LongestPalindromicSubstring.longestPalindrome(""));

        String maxLengthString = new String(new char[1000]).replace("\0", " ");
        assertThrows(InvalidParameterException.class, () -> LongestPalindromicSubstring.longestPalindrome(maxLengthString));

        // Input: s = "babad"
        // Output: "bab", or "aba" (equal length).
        String stringToTest = "babad";
        List<String> possibleSolutions = new ArrayList<>(Arrays.asList("bab", "aba"));

        String actual = LongestPalindromicSubstring.longestPalindrome(stringToTest);
        assertTrue(possibleSolutions.contains(actual));

        // Input: s = "anotherracecarmakesanappearance"
        // Output: "racecar"

        stringToTest = "anotherracecarmakesanappearance";
        String expected = "racecar";

        actual = LongestPalindromicSubstring.longestPalindrome(stringToTest);
        assertEquals(expected, actual);

    }

}
