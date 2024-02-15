package minmaxcritical;

import mergenodesinbetweenzeros.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NumNodesTest {
    NumNodes test;
    @BeforeEach
    void init() {
        test = new NumNodes();
    }

    @Test
    void testNodesBetweenCriticalPoints() {
        // 5,3,1,2,5,1,2]
        ListNode list = new ListNode(5, new ListNode(3, new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(1, new ListNode(2)))))));
        int[] expected = new int[]{1,3};
        int[] res = test.nodesBetweenCriticalPoints(list);
        assertArrayEquals(expected, res);

        assertArrayEquals(expected, test.nodesBetweenCriticalPointsBetter(list));
    }
}
