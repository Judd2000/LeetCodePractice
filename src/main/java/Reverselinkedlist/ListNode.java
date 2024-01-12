package Reverselinkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        ListNode cur = this;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.val);
            if (cur.next != null) {
                builder.append(", ");
            }
            cur = cur.next;
        }
        return builder.toString();
    }
}
