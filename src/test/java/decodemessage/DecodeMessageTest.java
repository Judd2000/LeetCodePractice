package decodemessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeMessageTest {
    DecodeMessage message;

    @BeforeEach
    void setup() {
        message = new DecodeMessage();
    }

    @Test
    void testDecodeMessage() {
        // Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
        // Output: "this is a secret"
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String expected = "this is a secret";

        assertEquals(expected, this.message.decodeMessage(key, message));

        // Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
        // Output: "the five boxing wizards jump quickly"
        key = "eljuxhpwnyrdgtqkviszcfmabo";
        message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        expected = "the five boxing wizards jump quickly";

        assertEquals(expected, this.message.decodeMessage(key, message));
    }
}
