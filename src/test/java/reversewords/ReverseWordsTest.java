package reversewords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsTest {
    ReverseWords test;

    @BeforeEach
    void setup() {
        test = new ReverseWords();
    }

    @Test
    void testReverseWords() {
        // Input: s = "Let's take LeetCode contest"
        // Output: "s'teL ekat edoCteeL tsetnoc"
        String input = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";

        assertEquals(expected, test.reverseWords(input));

        input = "Peter Piper Picked a Peck of Pickled Peppers";
        expected = "reteP repiP dekciP a kceP fo delkciP sreppeP";

        assertEquals(expected, test.reverseWords(input));
    }
}
