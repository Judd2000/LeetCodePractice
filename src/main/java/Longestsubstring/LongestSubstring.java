package Longestsubstring;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
//    0 <= s.length <= 5 * 10^4
//    s consists of English letters, digits, symbols and spaces.


    private LongestSubstring() {
    }

    public static final Character[] chars = new Character[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','!','@','#','$','%','^','&','*','(','\'',')','_','+','{','"','}',';',':','/','.','>',',','<','~','`', '?'};
    private static final Set<Character> validChars = new HashSet<>(Arrays.asList(chars));

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() >= (50000)) {
            throw new InvalidParameterException("String is too long, must be maximum length of 5 * 10 ^ 4");
        }
        for (int i = 0; i < s.length(); i++) {
            if (!validChars.contains(s.charAt(i))) {
                throw new InvalidParameterException("String contains invalid character: " + s.charAt(i) + ". Valid characters are: " + Arrays.toString(chars));
            }
        }
        // Approach with a hash set
        Set<Character> chars = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            if (!chars.contains(s.charAt(right))) {
                // If char not present, add it. Update max length.
                chars.add(s.charAt(right));
                // see if new length exceeds current max.
                int currentSubstrLen = right - left + 1;
                maxLen = Math.max(maxLen, currentSubstrLen);
            } else {
                // Remove all the letters up to the current letter.
                while (chars.contains(s.charAt(right))) {
                    chars.remove(s.charAt(left));
                    // shift left over to new substr candidate position.
                    left++;
                }
                // Since next string can begin at this repeated character, make sure to add it back.
                chars.add(s.charAt(right));
            }
        }
        return maxLen;
    }
}
