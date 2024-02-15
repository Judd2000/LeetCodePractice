package rangesumquery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeSumTest {

    RangeSum test;
    @Test
    void testSumRange() {
//        ["NumArray","sumRange","sumRange","sumRange"]
//        [[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]
//        [null,1,-1,-3]
        test = new RangeSum(new int[]{-2,0,3,-5,2,-1});

        int left = 0;
        int right = 2;
        int expectedSum = 1;

        assertEquals(expectedSum, test.sumRange(left, right));
    }
}
