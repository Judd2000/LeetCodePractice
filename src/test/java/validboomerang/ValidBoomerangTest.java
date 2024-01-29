package validboomerang;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidBoomerangTest {
    @Test
    void testIsBoomerang() {

        ValidBoomerang classToTest = new ValidBoomerang();

        assertThrows(InvalidParameterException.class, () -> classToTest.isBoomerang(new int[][]{{0,0}, {0,0}}));
        assertThrows(InvalidParameterException.class, () -> classToTest.isBoomerang(new int[][]{{0,0}, {0,0},
                {0,0}, {0,0}, {0,0}}));

        int[][] points = new int[][]{{1,1}, {2,3}, {3,2}};
        boolean expected = true;

        assertEquals(expected, classToTest.isBoomerang(points));

        points = new int[][]{{0,0}, {1,1}, {1,1}};
        expected = false;

        assertEquals(expected, classToTest.isBoomerang(points));

        points = new int[][]{{1,0}, {1,1}, {1,0}};

        assertEquals(expected, classToTest.isBoomerang(points));

        points = new int[][]{{73,31}, {73,19}, {73,45}};
        assertEquals(expected, classToTest.isBoomerang(points));

        points = new int[][]{{0,1}, {0,2}, {1,2}};
        expected = true;
        assertEquals(expected, classToTest.isBoomerang(points));
    }
}
