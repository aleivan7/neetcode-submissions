class LRUCache {
    // 1. Define the internal Node structure
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    
    // Pseudo-nodes (sentinels) to avoid messy null-pointer checks
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize sentinels and link them together
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        moveToHead(node); // It was used, move it to the front
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing value and refresh its position
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // Check if we need to evict the oldest item
            if (map.size() >= capacity) {
                Node oldest = tail.prev; // The node right before the tail sentinel
                removeNode(oldest);
                map.remove(oldest.key); // Erase from map
            }
            
            // Insert new item
            Node newNode = new Node(key, value);
            addAtHead(newNode);
            map.put(key, newNode);
        }
    }

    // --- Helper Methods for List Manipulation ---

    // Adds a node right after the head sentinel (Most Recently Used)
    private void addAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Completely unlinks a node from its current neighbors
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Moves an existing node to the front of the list
    private void moveToHead(Node node) {
        removeNode(node);
        addAtHead(node);
    }
}
