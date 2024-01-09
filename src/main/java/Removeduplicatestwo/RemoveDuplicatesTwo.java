package Removeduplicatestwo;

public class RemoveDuplicatesTwo {

    public static int removeDuplicates(int[] nums) {
        //        Input: nums = [1,1,1,2,2,3]
        //        Output: 5, nums = [1,1,2,2,3,_]
        int index = 1;
        int numSeen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                numSeen++;
            } else {
                numSeen = 1;
            }

            if (numSeen <= 2) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
