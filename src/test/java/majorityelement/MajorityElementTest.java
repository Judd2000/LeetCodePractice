package majorityelement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElementTest {

    @Test
    void testMajorityElement() {
        // Input: nums = [3,2,3]
        // Output = 3;
        int[] nums = new int[]{3,2,3};
        int expectedSolution = 3;

        int actual = MajorityElement.majorityElement(nums);
        assertEquals(expectedSolution, actual);

        // Input: nums = [2,2,1,1,1,2,2]
        // Output = 2

        nums = new int[]{2,2,1,1,1,2,2};
        expectedSolution = 2;

        actual = MajorityElement.majorityElement(nums);
        assertEquals(expectedSolution, actual);

        nums = new int[]{2,2,2,2,2,2,2,3,3,4,3,6,7,7,7,7,7,7,7,7,7,7};
        expectedSolution = 7;

        actual = MajorityElement.majorityElement(nums);
        assertEquals(expectedSolution, actual);

        nums = new int[]{2,1,2,3,2,8,2,9,2,11,2,6,2};
        expectedSolution = 2;

        // In this case the alternating nature of two makes it the last element candidate.
        actual = MajorityElement.majorityElement(nums);
        assertEquals(expectedSolution, actual);
    }
}
