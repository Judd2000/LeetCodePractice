package RemoveElement;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveElementTest {

    @Test
    void testRemoveElement() {
        int[] nums = new int[]{1,5,4,3,6,7,4,1};
        int val = 4; // Value to remove
        int[] expectedNums = new int[]{1,5,3,6,7,1}; // The expected answer with correct length
        // It is sorted with no values equaling val.
        checkSolution(nums, val, expectedNums);

        /*
        Example 1:

        Input: nums = [3,2,2,3], val = 3
        Output: 2, nums = [2,2,_,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 2.
        It does not matter what you leave beyond the returned k (hence they are underscores).
        */
        nums = new int[]{3,2,2,3};
        val = 3;
        expectedNums = new int[]{2,2};

        checkSolution(nums, val, expectedNums);
        /*
        Example 2:

        Input: nums = [0,1,2,2,3,0,4,2], val = 2
        Output: 5, nums = [0,1,4,0,3,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
        Note that the five elements can be returned in any order.
         It does not matter what you leave beyond the returned k (hence they are underscores).
         */
        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        expectedNums = new int[]{0,1,4,0,3};
        checkSolution(nums, val, expectedNums);
    }

    private void checkSolution(int[] nums, int val, int[] expected) {
        int k = RemoveElement.removeElement(nums, val); // Calls your implementation

        assertEquals(expected.length, k);
        nums = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(nums);
        Arrays.sort(expected);
        assertArrayEquals(expected, nums);
    }
}
