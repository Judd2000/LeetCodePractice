package combinationsum;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

        List<List<Integer>> result = test.combinationSum(candidates, target);
        assertEquals(2, result.size());
    }
}
