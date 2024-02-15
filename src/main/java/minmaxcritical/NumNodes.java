package minmaxcritical;

import mergenodesinbetweenzeros.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumNodes {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pointer = head;

        List<ListNode> criticalPoints = new ArrayList<>();

        Map<ListNode, Integer> critPointIndices = new HashMap<>();

        int[] minMax = new int[2];

        ListNode prev = null;
        int index = 0;
        while (pointer != null) {
            // check if node is a start or end node
            if (prev != null && pointer.next != null && ((pointer.val < prev.val && pointer.val < pointer.next.val)
                        || (pointer.val > prev.val && pointer.val > pointer.next.val))) {
                    // we have a critical point!
                    criticalPoints.add(pointer);
                    critPointIndices.put(pointer, index);
            }
            prev = pointer;
            pointer = pointer.next;
            index++;
        }
        if (!criticalPoints.isEmpty() && criticalPoints.size() > 1) {
            minMax[1] = critPointIndices.get(criticalPoints.get(criticalPoints.size() - 1)) - critPointIndices.get(criticalPoints.get(0));
            for (int i = 0; i < criticalPoints.size(); i++) {
                ListNode comparee = criticalPoints.get(i);
                int compareeIndex = critPointIndices.get(comparee);
                if (i < criticalPoints.size() - 1) {
                    // compare next
                    ListNode toCompare = criticalPoints.get(i + 1);
                    newMinMax(critPointIndices.get(toCompare), compareeIndex, minMax);
                }
                if (i > 0) {
                    // compare previous
                    ListNode toCompare = criticalPoints.get(i - 1);
                    newMinMax(critPointIndices.get(toCompare), compareeIndex, minMax);
                }
            }
        } else {
            minMax[0] = -1;
            minMax[1] = -1;
        }

        return minMax;
    }

    private void newMinMax(int toCompare, int comparee, int[] maxMin) {
        int distance = Math.abs(toCompare - comparee);
        if (maxMin[0] == 0) {
            maxMin[0] = distance;
        }
        if (distance < maxMin[0]) {
            maxMin[0] = distance;
        }
    }

    public int[] nodesBetweenCriticalPointsBetter(ListNode head) {
        if (head.next.next == null) {
            return new int[]{-1,-1};
        }
        int index = 2;                 // to see the index it is 2 because 1st node cant be critical point
        ListNode prev = head;          // point to previous node of current node
        ListNode curr = head.next;     // to traverse linked list
        int min = Integer.MAX_VALUE;  //to store first critical point
        int max = Integer.MIN_VALUE;  // to store last critical point
        int min_diff = Integer.MAX_VALUE; //to store the minimum distance btw to critical point
        int prevs = 0;               // to store index of previous critical point
        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) { // condition
                max = Math.max(max, index); // finding last critical point
                min = Math.min(min, index); // finding first critical point
                if (prevs != 0)  { //  if this is the second critical point then find its distance with the previous critical point
                    min_diff = Math.min(min_diff, index - prevs);
                }
                prevs = index;             // shift the previous critical point to the current one
            }
            prev = curr;               // update the previous pointer
            curr = curr.next;         // move to the next node
            index++;               // increase the index
        }

        if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE && min != max) {
            return new int[]{min_diff,max - min};  // max distance is always between first and last critical point and minimum we have already maintained;
        }
        else {
            return new int[]{-1,-1};
        }
    }
}
