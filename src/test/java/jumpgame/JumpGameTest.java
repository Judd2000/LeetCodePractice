package jumpgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JumpGameTest {
    JumpGame test;

    @BeforeEach
    void init() {
        test = new JumpGame();
    }

    @Test
    void testCanJump() {
//        Input: nums = [2,3,1,1,4]
//        Output: true
        int[] input = new int[]{2,3,1,1,4};
        assertTrue(test.canJump(input));

//        Input: nums = [3,2,1,0,4]
//        Output: false
//        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
        input = new int[]{3,2,1,0,4};
        assertFalse(test.canJump(input));
    }
}
