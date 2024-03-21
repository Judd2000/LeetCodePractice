package combinationsum;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationSumTest {
    CombinationSum test;

    @BeforeEach
    void setup() {
        test = new CombinationSum();
    }

    @Test
    void testCombinationSum() {
        // candidates: 2 3 6 7
        // target: 7
        // expected: [2,2,3],[7]

        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<Integer> list = Arrays.asList(2,2,3);
        List<Integer> secondList = List.of(7);
        int[][] expected = {{2,2,3}, {7}};
        List<List<Integer>> result = test.combinationSum(candidates, target);
        assertEquals(2, result.size());
        assertArrayEquals(expected, convertListToArray(result));
    }

    private int[][] convertListToArray(List<List<Integer>> listOfLists) {
        int[][] array = new int[listOfLists.size()][];

        for (int i = 0; i < listOfLists.size(); i++) {
            List<Integer> list = listOfLists.get(i);
            array[i] = new int[list.size()];

            for (int j = 0; j < list.size(); j++) {
                array[i][j] = list.get(j);
            }
        }

        return array;
    }
}
