package RangeSum2D;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RowSum2DTest {
    RangeSum2D test;
    @Test
    void testSumRegion() {
        // ["NumMatrix","sumRegion","sumRegion","sumRegion"]
        // [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        // [2,1,4,3],[1,1,2,2],[1,2,2,4]
        // [8,11,12]
        test = new RangeSum2D(matrix);
        int expected = 8;
        int x1 = 2;
        int y1 = 1;
        int x2 = 4;
        int y2 = 3;
        assertEquals(expected, test.sumRegion(x1, y1, x2, y2));
    }
}
