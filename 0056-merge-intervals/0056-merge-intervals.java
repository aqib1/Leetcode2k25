class Solution {
    static class Node {
        Node left;
        Node right;
        int[] interval;

        Node() {

        }

        Node(int[] interval) {
            this.interval = interval;
        }
    }

    Node root;

    void insert(int[] interval) {
        if (root == null)
            root = new Node(interval);
        else
            addChild(root, interval);
    }

    void addChild(Node root, int[] interval) {
        if (interval[1] < root.interval[0]) {
            if (root.left == null) {
                root.left = new Node(interval);
            } else
                addChild(root.left, interval);
        } else if (interval[0] > root.interval[1]) {
            if (root.right == null) {
                root.right = new Node(interval);
            } else {
                addChild(root.right, interval);
            }
        } else {
            root.interval[0] = Math.min(root.interval[0], interval[0]);
            root.interval[1] = Math.max(root.interval[1], interval[1]);
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

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(var interval: intervals) {
            insert(interval);
        }

        return inOrder();
    }
}