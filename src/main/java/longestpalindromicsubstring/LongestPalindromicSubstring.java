package longestpalindromicsubstring;

import java.security.InvalidParameterException;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() >= 1000 || s.isEmpty()) {
            throw new InvalidParameterException("String is too long or too short. Length " +
                    "must be greater than 0 and less than 1000. Your length: " +  s.length());
        }
        // 2D Dynamic Programming
//        Look for the most basic case (like recursion!)
//        Define sub problems
//        Define branches
//        Build upon the previous optimal solution
//
//        Maintain a boolean table[N][N] that is filled in a bottom-up manner.
//                Iterate for all possible lengths from 1 to N:
//        For each length iterate from i = 0 to N-length:
//        Find the end of the substring j = i+length-1.
//        The value of table[i][j] is true, if the substring is palindrome, otherwise false.
//                To calculate table[i][j], check the value of table[i+1][j-1]:
//        if the value is true and str[i] is the same as str[j], then we make table[i][j] true.
//                Otherwise, the value of table[i][j] is made false.
//                We have to fill the table initially for substrings of length = 1 and length = 2.
//        Update the longest palindrome accordingly whenever a new palindrome of greater length is found.

        //Create memoization table. Most basic case - a single letter is a palindrome.
        boolean[][] palindromeTable = new boolean[s.length() - 1][s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            palindromeTable[i][i] = true;
        }
        int maxLen = 1;
        // check for palindromes of length 2
        int startIndex = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindromeTable[i][i + 1] = true; // place a "true" at the next-over table location
                startIndex = i;
                maxLen = 2;
            }
        }
        // for substrings 3 and greater - up to the length of the original string
        for (int curSubstringLen = 3; curSubstringLen <= s.length(); curSubstringLen++) {
            for (int i = 0; i < s.length() - curSubstringLen + 1; ++i) {
                // candidate substring's end index (current index + current length considered - 1)
                int endSubstrIndex = i + curSubstringLen - 1;

                // if next to the right and up in the palindrome table exists, and both sides of our
                // substring are equal, we know we have a palindrome.
                if (palindromeTable[i + 1][endSubstrIndex - 1] && s.charAt(i) == s.charAt(endSubstrIndex)) {
                    palindromeTable[i][endSubstrIndex] = true;

                    // if the current length of the substring that produced a valid palindrome is greater,
                    // update max length to equal curSubstringLen.
                    if (curSubstringLen > maxLen) {
                        startIndex = i;
                        maxLen = curSubstringLen;
                    }
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }
}
