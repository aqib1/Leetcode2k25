/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // Time complexity O(n) and space O(n)
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()) {
            var size = bfs.size();
            for(int i = 0; i < size; i++) {
                var current = bfs.poll();
                if(i != size - 1) {
                    current.next = bfs.peek();
                }

                if(current.left != null) {
                    bfs.add(current.left);
                }

                if(current.right != null) {
                    bfs.add(current.right);
                }
            }
        }

        return root;
    }
}