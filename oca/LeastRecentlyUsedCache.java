package oca;
import java.util.*;

class LeastRecentlyUsedCache {

    // Node class to represent the doubly linked list nodes
    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    // Constructor
    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Create dummy head and tail nodes for easier manipulation
        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        // Initialize the list
        head.next = tail;
        tail.prev = head;
    }

    // Get the value from the cache
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Move the accessed node to the front (most recently used)
            moveToHead(node);
            return node.value;
        }
        return -1; // Not found
    }

    // Put a new value into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the value and move the node to the front
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // Create a new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);

            // If the cache exceeds capacity, remove the least recently used (tail)
            if (cache.size() > capacity) {
                Node tailNode = removeTail();
                cache.remove(tailNode.key);
            }
        }
    }

    // Move the node to the head (most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Add a node right after the head (most recently used)
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the linked list
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Remove the tail node (least recently used)
    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    // Main for testing the LRUCache class
    public static void main(String[] args) {
        LeastRecentlyUsedCache cache = new LeastRecentlyUsedCache(2);

        // Test put and get methods
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // Returns 1
        cache.put(3, 3); // Evicts key 2
        System.out.println(cache.get(2)); // Returns -1 (not found)
        cache.put(4, 4); // Evicts key 1
        System.out.println(cache.get(1)); // Returns -1 (not found)
        System.out.println(cache.get(3)); // Returns 3
        System.out.println(cache.get(4)); // Returns 4
    }
}
