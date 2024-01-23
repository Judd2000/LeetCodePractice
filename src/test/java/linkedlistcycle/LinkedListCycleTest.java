package linkedlistcycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListCycleTest {
    LinkedListCycle classToTest;

    @BeforeEach()
    void setUp() {
        this.classToTest = new LinkedListCycle();
    }

    @Test
    void testHasCycle() {
        //  Input: head = [3,2,0,-4] -4 points back at two, pos = 1
        //  Output: true
        ListNode cycleNode = new ListNode(2);
        ListNode testList = new ListNode(3, cycleNode);
        cycleNode.next = new ListNode(0, new ListNode(-4, cycleNode));

        assertTrue(classToTest.hasCycle(testList));

        // Input: head = [1,1,1,1], none points back to the other (not value-dependent)
        ListNode secondTestList = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, null))));
        assertFalse(classToTest.hasCycle(secondTestList));

        // Case where cycle points back to same-number node - make sure memory comparison and NOT value comparison
        cycleNode = new ListNode(15);
        testList = new ListNode(1, new ListNode(3, new ListNode(5, cycleNode)));
        cycleNode.next = new ListNode(14, new ListNode(15, new ListNode(15, cycleNode)));

        assertTrue(classToTest.hasCycle(testList));
    }
}
