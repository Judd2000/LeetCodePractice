package Reverselinkedlist;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        // non-recursive
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
