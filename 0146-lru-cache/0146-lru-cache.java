public class LRUCache {

    private final Map<Integer, Node> cacheMap;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        var value = -1;
        if (cacheMap.containsKey(key)) {
            var current = cacheMap.get(key);
            value = current.value;
            removeNode(current);
            addNode(current);
        }
        return value;
    }

    private void addNode(Node current) {
        tail.prev.next = current;
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
    }

    private void removeNode(Node current) {
        var prev = current.prev;
        prev.next = current.next;
        current.next.prev = prev;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            var current = cacheMap.get(key);
            removeNode(current);
            current.value = value;
            addNode(current);
        } else {
            if (cacheMap.size() == capacity) {
                cacheMap.remove(head.next.key);
                removeNode(head.next);
            }
            var node = new Node(key, value);
            cacheMap.put(key, node);
            addNode(node);
        }
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
