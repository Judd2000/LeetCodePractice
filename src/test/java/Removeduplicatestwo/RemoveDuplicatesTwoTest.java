package Removeduplicatestwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTwoTest {

    @Test
    void testRemoveDuplicates() {
//        Input: nums = [1,1,1,2,2,3]
//        Output: 5, nums = [1,1,2,2,3,_]
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] expected = new int[]{1,1,2,2,3};
        int expectedLen = 5;

        int actualLen = RemoveDuplicatesTwo.removeDuplicates(nums);
        assertEquals(expectedLen, actualLen);
        for (int i = 0; i < expectedLen; i++) {
            assertEquals(nums[i], expected[i]);
        }

//        Input: nums = [0,0,1,1,1,1,2,3,3]
//        Output: 7, nums = [0,0,1,1,2,3,3,_,_]
        nums = new int[]{0,0,1,1,1,1,2,3,3,};
        expected = new int[]{0,0,1,1,2,3,3};
        expectedLen = 7;

        actualLen = RemoveDuplicatesTwo.removeDuplicates(nums);
        assertEquals(expectedLen, actualLen);
        for (int i = 0; i < expectedLen; i++) {
            assertEquals(nums[i], expected[i]);
        }

//        Input: nums = [0,0,0,0,0,0,1,1,6,6,6,7,8,8,9,9,9,9,9,9,10,10,10]
//        Output: 13, nums = [0,0,1,1,6,6,7,8,8,9,9,10,10,.....]
        nums = new int[]{0,0,0,0,0,0,1,1,6,6,6,7,8,8,9,9,9,9,9,9,10,10,10};
        expected = new int[]{0,0,1,1,6,6,7,8,8,9,9,10,10};
        expectedLen = 13;

        actualLen = RemoveDuplicatesTwo.removeDuplicates(nums);
        assertEquals(expectedLen, actualLen);
        for (int i = 0; i < expectedLen; i++) {
            assertEquals(nums[i], expected[i]);
        }
    }
}
