package possibledicerolls;

public class DiceRolls {
    private static final int MOD_VALUE = (int) (Math.pow(10, 9) + 7);

    public int numRollsToTarget(int n, int k, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // base case, 1 way to roll 0 dice to 0
        for (int dice = 0; dice < n; dice++) {
            int[] next = new int[target + 1];

            for (int roll = 1; roll < k + 1; roll++) {
                for (int targetValue = roll; targetValue < target + 1; targetValue++) {
                    next[targetValue] = (next[targetValue] + dp[targetValue - roll]) % MOD_VALUE;
                }
            }
            dp = next;
        }
        return dp[target];
    }
}
