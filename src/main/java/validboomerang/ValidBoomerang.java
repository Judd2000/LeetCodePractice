package validboomerang;

import java.security.InvalidParameterException;

public class ValidBoomerang {

    public boolean isBoomerang(int[][] points) {
        if (points.length != 3){
            throw new InvalidParameterException("Points array must be of size 3");
        }
        // To find the area of a triangle with 3 points, 1/2 *  abs (( x1 (y2 - y3) + x2 (y3 - y1) + x3 (y1 - y2) )).
        // if we have a triangle, we know that the slopes differ and we have no repeating vertices.
        // We only care if the value is nonzero. So, we can reduce some computation by avoiding the Math.abs and the * 1/2
        double trapAreaOne = (double) points[0][0] * (points[1][1] - points[2][1]);
        double trapAreaTwo = (double) points[1][0] * (points[2][1] - points[0][1]);
        double trapAreaThree = (double) points[2][0] * (points[0][1] - points[1][1]);

        return trapAreaOne + trapAreaTwo + trapAreaThree != 0;
    }
}
