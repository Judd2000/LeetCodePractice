package linkedlistcycle;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // Floyd's Cycle-Finding Algorithm! O(n) time and O(1) space.
        ListNode laggingPointer = head;
        ListNode fastPointer = head;
        while (laggingPointer != null && fastPointer != null && fastPointer.next != null) {
            laggingPointer = laggingPointer.next;
            fastPointer = fastPointer.next.next;
            if (laggingPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
