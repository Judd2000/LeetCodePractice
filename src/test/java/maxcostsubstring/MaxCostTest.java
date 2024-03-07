package maxcostsubstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxCostTest {
    MaxCost test;

    @BeforeEach
    void init() {
        test = new MaxCost();
    }

    @Test
    void testMaximumCostSubstring() {
        String input = "adaa";
        String charactersWithCost = "d";
        int[] valuesOfCharacters = new int[]{-1000};

        int expectedLongest = 2;
        assertEquals(expectedLongest, test.maximumCostSubstring(input, charactersWithCost, valuesOfCharacters));

        input = "talaqlt";
        charactersWithCost = "tqla";
        valuesOfCharacters = new int[]{4,3,3,-2};

        expectedLongest = 13;
        assertEquals(expectedLongest, test.maximumCostSubstring(input, charactersWithCost, valuesOfCharacters));
    }
}
