package Ransomnote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineCounts = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char curChar = Character.toLowerCase(magazine.charAt(i));
            if (curChar == ' ') {
                continue;
            }
            if (magazineCounts.containsKey(curChar)) {
                magazineCounts.put(curChar, magazineCounts.get(curChar) + 1);
            } else {
                magazineCounts.put(curChar, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char curChar = Character.toLowerCase(ransomNote.charAt(i));
            if (curChar == ' ') {
                continue;
            }
            if (magazineCounts.containsKey(curChar) && magazineCounts.get(curChar) > 0) {
                magazineCounts.put(curChar, magazineCounts.get(curChar) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstructArrayEdition(String ransomNote, String magazine) {
        int[] alphaOccurances = new int[26];
        // array index is current character toLowerCase - 'a'
        for (int i = 0; i < magazine.length(); i++) {
            char curChar = Character.toLowerCase(magazine.charAt(i));
            if (curChar == ' ' || curChar == '\n') {
                continue;
            }
            alphaOccurances[curChar-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char curChar = Character.toLowerCase(ransomNote.charAt(i));
            if (curChar == ' ' || curChar == '\n') {
                continue;
            }
            if (alphaOccurances[curChar-'a'] == 0) {
                return false;
            }
            alphaOccurances[curChar-'a']--;
        }
        return true;
    }
}