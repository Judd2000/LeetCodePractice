package validpalindrome;
import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Character.isLetterOrDigit;

public class ValidPalindrome {

    private ValidPalindrome() {}
    public static boolean isPalindrome(String s) {
        String str = removeNonAlphaNumerics(s);
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            char stackChar = stack.pop();
            char curChar = str.charAt(i);
            if (stackChar != curChar) {
                return false;
            }
        }
        return true;
    }

    private static String removeNonAlphaNumerics(String s) {
        StringBuilder sb = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < s.length(); i++, j++) {
            char curChar = s.charAt(i);
            if (!isLetterOrDigit(curChar)) {
                sb.deleteCharAt(j);
                j--;
            }
        }
        return sb.toString().toLowerCase();
    }

    // Less memory and less overhead - slightly harder to read
    public static boolean isPalindromeTwo(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
