package validpalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeTest {
    @Test
    void testIsPalindrome() {
        // Empty string
        assertTrue(ValidPalindrome.isPalindrome(""));
        assertTrue(ValidPalindrome.isPalindromeTwo(""));

        // Single-character string
        assertTrue(ValidPalindrome.isPalindrome("q"));
        assertTrue(ValidPalindrome.isPalindromeTwo("q"));

        // Input: s = "A man, a plan, a canal: Panama"
        // Output: true
        String checkPalindrome = "A man, a plan, a canal: Panama";
        assertTrue(ValidPalindrome.isPalindrome(checkPalindrome));
        assertTrue(ValidPalindrome.isPalindromeTwo(checkPalindrome));
    }
}
