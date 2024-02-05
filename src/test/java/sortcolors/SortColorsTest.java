package sortcolors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortColorsTest {
    SortColors test;
    @BeforeEach
    void init() {
        test = new SortColors();
    }

    @Test
    void testSortColors() {
        // Input: nums = [2,0,2,1,1,0]
        // Output: [0,0,1,1,2,2]
        int[] nums = new int[]{2,0,2,1,1,0};
        int[] expected = new int[]{0,0,1,1,2,2};

        test.sortColorsMap(nums);
        assertArrayEquals(expected,nums);

        nums = new int[]{2,0,2,1,1,0};

        test.sortColorsArray(nums);
        assertArrayEquals(expected, nums);

        // Input: nums = [2,0,1]
        // Output: [0,1,2]
        nums = new int[]{2,0,1};
        expected = new int[]{0,1,2};

        test.sortColorsMap(nums);
        assertArrayEquals(expected,nums);

        nums = new int[]{2,0,1};

        test.sortColorsArray(nums);
        assertArrayEquals(expected,nums);
    }
}
