package reversestring;

public class ReverseString {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start <= end) {
            char holdEnd = s[end];
            s[end] = s[start];
            s[start] = holdEnd;
            start++;
            end--;
        }
    }
}
