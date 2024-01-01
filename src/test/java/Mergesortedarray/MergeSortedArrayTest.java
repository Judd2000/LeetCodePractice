package Mergesortedarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {
    MergeSortedArray merge;


    @BeforeEach
    public void init() {
        this.merge = new MergeSortedArray();
    }

    @Test
    void testMerge() {
        /* Example 1:

            Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
            Output: [1,2,2,3,5,6]
            Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
            The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
       */
        int[] testArray = new int[]{1, 2, 3, 0, 0, 0};
        int[] arrayToMerge = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        this.merge.merge(testArray, m, arrayToMerge, n);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, testArray);


        testArray = new int[]{1, 2, 3, 6, 9, 12, 0, 0, 0, 0};
        arrayToMerge = new int[]{4, 5, 6, 7};
        m = 6;
        n = 4;
        this.merge.merge(testArray, m, arrayToMerge, n);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 9, 12}, testArray);

        // Example 2:
        //
        //Input: nums1 = [1], m = 1, nums2 = [], n = 0
        //Output: [1]
        //Explanation: The arrays we are merging are [1] and [].
        //The result of the merge is [1].

        testArray = new int[]{1};
        m = 1;
        arrayToMerge = new int[]{};
        n = 0;
        this.merge.merge(testArray, m, arrayToMerge, n);
        assertArrayEquals(new int[]{1}, testArray);

        /*
        Example 3:

        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        Output: [1]
        Explanation: The arrays we are merging are [] and [1].
        The result of the merge is [1].
        Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

        */
        testArray = new int[]{0};
        m = 0;
        arrayToMerge = new int[]{1};
        n = 1;
        this.merge.merge(testArray, m, arrayToMerge, n);
        assertArrayEquals(new int[]{1}, testArray);

        // Case where we should get an exception.

        testArray = new int[]{1, 2, 0};
        m = 3;
        arrayToMerge = new int[]{3, 4};
        n = 2;


        int[] finalTestArray = testArray;
        int finalM = m;
        int[] finalArrayToMerge = arrayToMerge;
        int finalN = n;
        assertThrows(InvalidParameterException.class, () -> {
            this.merge.merge(finalTestArray, finalM, finalArrayToMerge, finalN);
        });
    }
}
