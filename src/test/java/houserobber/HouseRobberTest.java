package houserobber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberTest {
    HouseRobber test;
    @BeforeEach
    void setup() {
        test = new HouseRobber();
    }

    @Test
    void testRob() {
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//                Total amount you can rob = 1 + 3 = 4.
        testRob(new int[]{1,2,3,1}, 4);
//        Input: nums = [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//                Total amount you can rob = 2 + 9 + 1 = 12.
        testRob(new int[]{2,7,9,3,1}, 12);
    }

    @Test
    void testRobCircle() {
        // Input: nums = [2,3,2]
        // Output: 3
        // Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
        testRobCircle(new int[]{2,3,2}, 3);

        // Input: nums = [1,2,3,1]
        // Output: 4
        testRobCircle(new int[]{1,2,3,1}, 4);

        // Input: [1,2,3]
        // Output: 3
        testRobCircle(new int[]{1,2,3}, 3);
    }

    private void testRob(int[] nums, int expected) {
        assertEquals(expected, test.rob(nums));
    }

    private void testRobCircle(int[] nums, int expected) {
        assertEquals(expected, test.robCircle(nums));
    }
}
