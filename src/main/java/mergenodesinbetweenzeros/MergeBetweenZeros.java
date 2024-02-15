package mergenodesinbetweenzeros;

public class MergeBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        // beginning and end of linked list will have node.val == 0
        ListNode pointer = head;
        boolean seenZero = false;
        ListNode oneBeforeZero = null;
        ListNode firstZeroPointer = null;
        int sum = 0;
        while (pointer != null) {
            if (pointer.next != null && pointer.next.val == 0 && !seenZero) {
                oneBeforeZero = pointer;
            } else if (pointer.val == 0 && !seenZero) {
                firstZeroPointer = pointer;
                seenZero = true;
            } else if (pointer.val == 0 && firstZeroPointer != null) {
                // for all nodes in between - sum up values
                // make a new node, removing all in-betweens
                ListNode newNode = new ListNode(sum, pointer.next);
                sum = 0;
                // If zero was the head, make newNode the new head.
                if (firstZeroPointer == head) {
                    head = newNode;
                }

                // if oneBeforeZero, make sure next is newNode
                if (oneBeforeZero != null) {
                    oneBeforeZero.next = newNode;
                }

                oneBeforeZero = newNode;
            } else {
                sum += pointer.val;
            }
            pointer = pointer.next;
        }
        return head;
    }
}
