package mergenodesinbetweenzeros;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MergeBetweenZerosTest {
    MergeBetweenZeros test;
    @BeforeEach
    void init() {
        test = new MergeBetweenZeros();
    }

    @Test
    void testMerge() {
        ListNode testList = new ListNode(0, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(0, new ListNode(1, new ListNode(1, new ListNode(0))))))));
        ListNode res = test.mergeNodes(testList);
        int three = 2 + 1;
    }
}
