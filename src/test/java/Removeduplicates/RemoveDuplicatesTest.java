package Removeduplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private int[] nums;

    private int[] expected;

    private int expectedLen;

    private int actualLen;
    @Test
    void removeDuplicatesTest() {
        nums = new int[]{1,1,2};
        expected = new int[]{1,2};
        expectedLen = 2;

        actualLen = RemoveDuplicates.removeDuplicates(nums);
        testDuplicatesRemoved();

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        expected = new int[]{0,1,2,3,4};
        expectedLen = 5;

        actualLen = RemoveDuplicates.removeDuplicates(nums);
        testDuplicatesRemoved();

        nums = new int[]{0,1,1,1,1,1,1,1,1,1,1,1,1,5};
        expected = new int[]{0,1,5};
        expectedLen = 3;

        actualLen = RemoveDuplicates.removeDuplicates(nums);
        testDuplicatesRemoved();
    }

    private void testDuplicatesRemoved() {
        assertEquals(expectedLen, actualLen);
        for (int i = 0; i < expected.length; i++){
            assertEquals(expected[i], nums[i]);
        }
    }
}
