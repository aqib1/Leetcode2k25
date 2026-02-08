class Solution {
    static class Node {
        Node left;
        Node right;
        int[] interval;

        Node(int[] interval) {
            this.interval = interval;
        }
    }

    Node root;
    
    void insert(int[] interval) {
        if(root == null) {
            root = new Node(interval);
        } else {
            addChildren(root, interval);
        }
    }

    void addChildren(Node node, int[] interval) {
        if(interval[1] < node.interval[0]) {
            if(node.left == null) {
                node.left = new Node(interval);
            } else {
                addChildren(node.left, interval);
            }

        } else if(interval[0] > node.interval[1]) {
            if(node.right == null) {
                node.right = new Node(interval);
            } else {
                addChildren(node.right, interval);
            }
        } else {
            node.interval[0] = Math.min(node.interval[0], interval[0]);
            node.interval[1] = Math.max(node.interval[1], interval[1]);
        }
    }

    int[][] inOrder() {
        List<int[]> inOrder = new ArrayList<>();
        inOrder(inOrder, root);
        return inOrder.toArray(new int[inOrder.size()][]);
    }

    void inOrder(List<int[]> inOrder, Node root) {
        if(root == null)
            return;

        inOrder(inOrder, root.left);
        inOrder.add(root.interval);
        inOrder(inOrder, root.right);
    }

    // Time complexity ON(logN)
    // Space O(N)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        for(int[] interval: intervals)
            insert(interval);

        return inOrder();
    }
}