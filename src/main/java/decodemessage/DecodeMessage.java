package decodemessage;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> cipher = new HashMap<>();
        final int[] counter = {0};
        // construct the cipher
        for (int i = 0; i < key.length(); i++) {
            char curChar = key.charAt(i);
            if (Character.isAlphabetic(curChar)) {
                char charToMap = (char) ('a' + counter[0]);
                cipher.computeIfAbsent(curChar, k -> {
                    counter[0]++;
                    return charToMap;
                });
            }
        }
        // now, substitute.
        char[] messageArray = message.toCharArray();
        for (int i = 0; i < messageArray.length; i++) {
            char curChar = messageArray[i];
            if (curChar != ' ') {
                messageArray[i] = cipher.get(curChar);
            }
        }
        return new String(messageArray);
    }
}
