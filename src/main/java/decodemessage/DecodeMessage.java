package decodemessage;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> cipher = new HashMap<>();
        final int[] counter = {0};
        for (int i = 0; i < key.length(); i++) {
            char curChar = key.charAt(i);
            if (curChar == ' ') {
                continue;
            }
            char charToMap = (char) ('a' + counter[0]);
            cipher.computeIfAbsent(curChar, k -> {
                counter[0]++;
                return charToMap;
            });
        }
        return "";
    }
}
