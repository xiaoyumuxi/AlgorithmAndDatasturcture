package LinkedList;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head = new Node(); // dummy head
    Node tail = new Node(); // dummy tail


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // 淘汰 key=2
        System.out.println(cache.get(2)); // -1

        cache.put(4, 4); // 淘汰 key=1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;// dummy相连一下
    }

    private void removeNode(Node p){
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }

    private void addToHead(Node p){
        p.next = head.next;
        head.next = p;
        p.next.prev = p;
        p.prev = head;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);

            if (map.size() > capacity) {
                Node removed = removeTail();
                map.remove(removed.key);
            }
        }
    }
}
