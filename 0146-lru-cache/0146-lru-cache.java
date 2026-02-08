public class LRUCache {
    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> cacheMap;

    // Time complexity O(1)
    // Space complexity O(n)
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.cacheMap = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
       var value = -1;
       if(cacheMap.containsKey(key)) {
            var node = cacheMap.get(key);
            value = node.value;
            removeNode(node);
            addNode(node);
       }
       return value;
    }

    public void addNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }


    public void removeNode(Node node) {
        var prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            var node = cacheMap.get(key);
            removeNode(node);
            node.value = value;
            addNode(node);
        } else {
            if(cacheMap.size() == capacity) {
                cacheMap.remove(head.next.key);
                removeNode(head.next);
            }
            var node = new Node(key, value);
            cacheMap.put(key, node);
            addNode(node);
        }
    }

    static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        Node() {

        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
