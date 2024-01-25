package lrucache;

import java.util.*;

class LRUCache {
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node end = new Node(-1, -1);
    Node begin = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> keyLocations = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        end.next = begin;
        begin.prev = end;
    }

    private void addNode(Node newNode) {
        Node temp = end.next;

        newNode.next = temp;
        newNode.prev = end;

        end.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode) {
        Node prevprev = delNode.prev;
        Node nextnext = delNode.next;

        prevprev.next = nextnext;
        nextnext.prev = prevprev;
    }

    public int get(int key) {
        if (keyLocations.containsKey(key)) {
            Node resNode = keyLocations.get(key);
            int ans = resNode.val;

            keyLocations.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            keyLocations.put(key, end.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyLocations.containsKey(key)) {
            Node curr = keyLocations.get(key);
            keyLocations.remove(key);
            deleteNode(curr);
        }

        if (keyLocations.size() == cap) {
            keyLocations.remove(begin.prev.key);
            deleteNode(begin.prev);
        }

        addNode(new Node(key, value));
        keyLocations.put(key, end.next);
    }
}