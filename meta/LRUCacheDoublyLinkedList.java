package meta;

import java.util.HashMap;

public class LRUCacheDoublyLinkedList {

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCacheDoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Dummy nodes to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertToHead(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    //For debugging purpose
    public void printCacheState() {
        Node current = head.next;
        System.out.print("Cache state: ");
        while (current != null && current != tail) {
            System.out.print("[" + current.key + ":" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCacheDoublyLinkedList cache = new LRUCacheDoublyLinkedList(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.printCacheState(); // [3:30] [2:20] [1:10]

        cache.get(1);
        cache.printCacheState(); // [1:10] [3:30] [2:20]

        cache.put(4, 40); // Evicts key 2
        cache.printCacheState(); // [4:40] [1:10] [3:30]

        System.out.println("Get 2: " + cache.get(2)); // -1
        System.out.println("Get 3: " + cache.get(3)); // 30
    }
}
