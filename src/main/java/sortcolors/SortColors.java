package sortcolors;

import java.util.HashMap;
import java.util.Map;

public class SortColors {

    int numColors = 3;
    public void sortColorsMap(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        // 0: red, 1: white, 2: blue
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }
        int index = 0;
        for (int i = 0; i < numColors; i++) {
            // i is the current color
            if (counts.containsKey(i)) {
                int colorCount = counts.get(i);
                while (colorCount > 0) {
                    nums[index] = i;
                    colorCount--;
                    index++;
                }
            }
        }
    }

    public void sortColorsArray(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else if (num == 1) {
                oneCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                nums[i] = 0;
                zeroCount--;
            } else if (oneCount > 0) {
                nums[i] = 1;
                oneCount--;
            } else {
                nums[i] = 2;
            }
        }
    }
}
