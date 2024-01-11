package Longestsubstring;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @Test
    void testLengthLongestSubstring() {
//        Input: s = "abcabcbb"
//        Output: 3, "abc"
        int expectedSubstrLen = 3;
        String stringToTest = "abcabcbb";
        assertEquals(expectedSubstrLen, LongestSubstring.lengthOfLongestSubstring(stringToTest));

//        Input: s = "bbbbb"
//        Output: 1, "b"
        stringToTest = "bbbbb";
        expectedSubstrLen = 1;
        assertEquals(expectedSubstrLen, LongestSubstring.lengthOfLongestSubstring(stringToTest));

//        Input: s = "pwwkew"
//        Output: 3
        stringToTest = "pwwkew";
        expectedSubstrLen = 3;
        assertEquals(expectedSubstrLen, LongestSubstring.lengthOfLongestSubstring(stringToTest));

//        Input: s = "whatdoesimpurameaninthecontextofthis?"
//        Output: 13, "whatdoesimpura"
        stringToTest = "whatdoesimpurameaninthecontextofthis?";
        expectedSubstrLen = 13;
        assertEquals(expectedSubstrLen, LongestSubstring.lengthOfLongestSubstring(stringToTest));

//        Test length requirement
        int MAX_LEN = 50000;
        final String maxLenString = randomLongString(MAX_LEN);
        assertThrows(InvalidParameterException.class, () -> LongestSubstring.lengthOfLongestSubstring(maxLenString));

//        Test length requirement edge case
        final String edgeCaseLength = randomLongString(MAX_LEN - 1);
        assertDoesNotThrow(() -> LongestSubstring.lengthOfLongestSubstring(edgeCaseLength));

//        Character requirement(s)
        final String incorrectStringOne = "¶Test";
        assertThrows(InvalidParameterException.class, () -> LongestSubstring.lengthOfLongestSubstring(incorrectStringOne));

        final String incorrectStringTwo = "Test Two±";
        assertThrows(InvalidParameterException.class, () -> LongestSubstring.lengthOfLongestSubstring(incorrectStringTwo));
    }

    private String randomLongString(int len) {
        Character[] chars = LongestSubstring.chars;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index = (int) (Math.random() * chars.length);
            builder.append(chars[index]);
        }
        return builder.toString();
    }
}
