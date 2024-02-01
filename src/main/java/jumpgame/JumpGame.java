package jumpgame;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // The goal to reach
        int destination = nums.length - 1;
        // start backwards!
        for (int i = nums.length - 2; i >= 0; i--) {
            // can we reach from here? If we can, let's see if the previous things can reach where we are now.
            // In the cases where we can't reach the destination from the index, we need to see if the previous element(s)
            // can make it here.
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }
        return destination == 0;
    }
}
