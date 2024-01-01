package Mergesortedarray;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class MergeSortedArray {

    /*
        Constraints:

        nums1.length == m + n
        nums2.length == n
        0 <= m, n <= 200
        1 <= m + n <= 200
        -10^9 <= nums1[i], nums2[j] <= 10^9
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length != m + n || nums1.length != m + nums2.length) {
            throw new InvalidParameterException("First array must have space for elements of the second array!");
        }
        int i = m-1 ,j = n-1;
        int k = m + n -1;
        // take advantage of their sorted order and compare last elements - gradually move them to the end of the list.
        while(i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        // edge case where the nums1 array is empty - fill with nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
