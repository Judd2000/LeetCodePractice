package Ransomnote;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RansomNoteTest {
    @Test
    void testCanConstruct() {
//        Input: ransomNote = "aa", magazine = "aab"
//        Output: true
        String ransomNote = "aa";
        String magazine = "aab";

        boolean result = RansomNote.canConstruct(ransomNote, magazine);
        assertTrue(result);

//        Input: ransomNote = "help me please", magazine = "Per use of the ephemeral seal"
//        Output: true
        ransomNote = "help me please";
        magazine = "Per use of the ephemeral seal";

        result = RansomNote.canConstruct(ransomNote, magazine);
        assertTrue(result);

//        One letter short - missing "t".
//        Input: "they know where I am", magazine = "ma i erehw wonkk yehh wha zjkw"
//        Output: false
        ransomNote = "they know where I am";
        magazine = "ma i erehw wonkk yehh wha zjkw";

        result = RansomNote.canConstruct(ransomNote, magazine);
        assertFalse(result);
    }
}
