package reversewords;

public class ReverseWords {
    public String reverseWords(String s) {
        // printable ASCII characters, no leading or trailing spaces, at least 1 word
        // all words separated by a single space.
        char[] strAsChars = s.toCharArray();
        int start = 0;
        int len = s.length();

        while(start < len) {
            if (strAsChars[start] == ' ') {
                start++;
                continue;
            }
            int end = start;
            while(end < len && strAsChars[end] != ' ') {
                end++;
            }
            int saveEnd = end - 1;
            while(start < saveEnd) {
                char tmp = strAsChars[start];
                strAsChars[start] = strAsChars[saveEnd];
                strAsChars[saveEnd] = tmp;
                start++;
                saveEnd--;
            }
            start = end;
        }
        return String.valueOf(strAsChars);
    }
}
