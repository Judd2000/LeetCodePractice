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

    public String reverseStringII(String s, int k) {
        char[] str = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i+=2*k) {
            int start = i;
            // In the case that there aren't k more characters, do so for the rest of the string.
            int end = Math.min(i + k - 1, len - 1);
            // Regular string reversal
            while (start < end) {
                char tmp = str[start];

                str[start] = str[end];
                str[end] = tmp;

                start++;
                end--;
            }
        }
        return new String(str);
    }
}
