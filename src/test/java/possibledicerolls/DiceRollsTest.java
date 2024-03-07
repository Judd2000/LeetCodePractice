package possibledicerolls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceRollsTest {
    DiceRolls test;
    @BeforeEach
    void init() {
        test = new DiceRolls();
    }

    @Test
    void testNumRollsToTarget() {
//        Input: n = 2, k = 6, target = 7
//        Output: 6
//        Explanation: You throw two dice, each with 6 faces.
//                There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
        int diceNum = 2;
        int possibleRolls = 6;
        int target = 7;

        int expected = 6;

        assertEquals(expected, test.numRollsToTarget(diceNum, possibleRolls, target));
    }
}
