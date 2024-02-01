package decodemessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        this.message.decodeMessage(key, message);
    }
}
