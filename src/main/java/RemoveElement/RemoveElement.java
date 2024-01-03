package RemoveElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    private RemoveElement() {}
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
