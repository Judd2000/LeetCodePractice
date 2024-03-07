package houserobber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HouseRobber {
    public int rob(int[] nums) {
        // DP and memoization
        // NO ADJACENT houses can be robbed.

        int costToRob = 0;
        int costToNotRob = 0;

        // build up max money robbed
        for (int num : nums) {
            // which is higher - the cost to rob the previous house or the cost to not rob it?
            int newCostToNotRob = Math.max(costToRob, costToNotRob);
            // the cost of robbing this house will be the previous cost to not rob plus the current house's cost
            costToRob = costToNotRob + num;
            costToNotRob = newCostToNotRob;
        }
        return Math.max(costToRob, costToNotRob);
    }

    public int robCircle(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // first house is the neighbor of the last one, last one is the neighbor of the first one.
        // use previous implementation to find max rob excluding first, and excluding last, houses.
        int excludeLast = rob(Arrays.copyOf(nums, nums.length - 1));
        int excludeFirst = rob(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(excludeFirst, excludeLast);
    }
}
