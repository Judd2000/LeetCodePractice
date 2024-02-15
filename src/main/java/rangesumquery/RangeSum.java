package rangesumquery;

public class RangeSum {
    private int[] sums;

    public RangeSum(int[] nums) {
        sums = nums;
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sums[right];
        }
        return sums[right] - sums[left - 1];
    }
}
