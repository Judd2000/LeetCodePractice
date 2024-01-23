package alloonedatastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOOne {
    static class Node {
        int count;

        Set<String> keys = new HashSet<>();

        Node prev;

        Node next;

        Node(String key, int count) {
            this.keys.add(key);
            this.count = count;
        }

        void addNext(Node node) {
            node.prev = this;
            node.next = this.next;
            this.next.prev = node;
            this.next = node;
        }

        void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    Map<String, Node> keyLocations = new HashMap<>();

    Node head = new Node("", -1);

    Node tail = new Node("", -1);
    public AllOOne() {
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        Node node = head;
        if (keyLocations.containsKey(key)) {
            node = keyLocations.get(key);
        }
        node.keys.remove(key);
        int count = node == head ? 1 : node.count + 1;
        if (node.next.count != count) {
            node.addNext(new Node(key, count));
        }
        node.next.keys.add(key);
        keyLocations.put(key, node.next);
        if (node != head && node.keys.isEmpty()) {
            node.remove();
        }
    }

    public void dec(String key) {
        if (!keyLocations.containsKey(key)) return;
        Node node = keyLocations.get(key);
        node.keys.remove(key);
        if (node.count > 1) {
            if (node.prev.count != node.count-1) {
                node.prev.addNext(new Node(key, node.count - 1));
            }
            node.prev.keys.add(key);
            keyLocations.put(key, node.prev);
        } else {
            keyLocations.remove(key);
        }

        if (node.keys.isEmpty())
            node.remove();
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}