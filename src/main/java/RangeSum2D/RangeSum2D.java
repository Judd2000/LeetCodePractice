package RangeSum2D;

public class RangeSum2D {

    int[][] sums;
    public RangeSum2D(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        sums = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
                // current row sum plus the sum of the above element.
                sums[i + 1][j + 1] = rowSum + sums[i][j + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // take sum at 1, row1 + 1, and col1 + 1, 1 and subtract it from sum at row2 + 1 col2 + 1. Add back top left

        // We will need to re-add top left!
        int topLeft = sums[row1][col1];

        // Sum to the left of our bounding square
        int leftSideSum = sums[row2 + 1][col1];

        // Sum above our bounding square
        int topSum = sums[row1][col2 + 1];

        // Total box sum in the bottom right corner of the matrix
        int totalSumAtBottom = sums[row2 + 1][col2 + 1];

        // Total sun minus the left and top rectangles -> re-add the overlap that was subtracted twice.
        return totalSumAtBottom - leftSideSum - topSum + topLeft;
    }
}
