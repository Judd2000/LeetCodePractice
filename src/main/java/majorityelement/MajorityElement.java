package majorityelement;

import java.util.Arrays;

public class MajorityElement {

    private MajorityElement() {}
    public static int majorityElement(int[] nums) {
        // Assumed that a majority element exists in the given array
        // Moore's voting algorithm
        int majorityIndex = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // If an element is truly majority, then it occurs > n/2 times and the
            // remaining elements less than that. If the count of other non-equal
            // elements is equal to or exceeds the current candidate, we know it
            // is no longer possible for it to be a majority element.

            // Therefore, a majority element must occur more times than the rest of all the elements.
            if (nums[majorityIndex] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        return nums[majorityIndex];
    }
}
