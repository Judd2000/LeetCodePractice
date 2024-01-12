package Reverselinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLinkedListTest {

    @Test
    void testToString() {
        ListNode firstHead = new ListNode(1);
        firstHead.next = new ListNode(2);
        firstHead.next.next = new ListNode(3);
        firstHead.next.next.next = new ListNode(4);

        ListNode secondHead = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        String firstHeadString = firstHead.toString();
        String secondHeadString = secondHead.toString();

        assertEquals(firstHeadString, secondHeadString);

        // Test null with same number of nodes
        ListNode thirdList = new ListNode();
        thirdList.next = new ListNode();
        thirdList.next.next = new ListNode();
        thirdList.next.next.next = new ListNode();

        ListNode fourthList  = new ListNode();
        fourthList.next = new ListNode();
        fourthList.next.next = new ListNode();
        fourthList.next.next.next = new ListNode();

        assertEquals(thirdList.toString(), fourthList.toString());
    }

    @Test
    void reverseLinkedListTest() {
        ListNode initialHead = new ListNode(1);
        initialHead.next = new ListNode(2);
        initialHead.next.next = new ListNode(3);
        initialHead.next.next.next = new ListNode(4);

        ListNode expectedHead = new ListNode(4);
        expectedHead.next = new ListNode(3);
        expectedHead.next.next = new ListNode(2);
        expectedHead.next.next.next = new ListNode(1);

        ListNode actualHead = ReverseLinkedList.reverseList(initialHead);

        assertEquals(expectedHead.toString(), actualHead.toString());

        ListNode longInitialHead = new ListNode(10, new ListNode(14, new ListNode(2, new ListNode(19, new ListNode(-1, new ListNode(4))))));
        ListNode longExpectedHead = new ListNode(4, new ListNode(-1, new ListNode(19, new ListNode(2, new ListNode(14, new ListNode(10))))));

        ListNode longActualHead = ReverseLinkedList.reverseList(longInitialHead);

        assertEquals(longExpectedHead.toString(), longActualHead.toString());
    }
}
