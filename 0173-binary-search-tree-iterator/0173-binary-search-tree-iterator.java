/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private final Stack<TreeNode> lifo;

    // space O(n) where n is number of nodes
    // Time complexity O(n) where n is number of left nodes to root
    public BSTIterator(TreeNode root) {
        this.lifo = new Stack<>();
        insertLeftMost(root);
    }

    private void insertLeftMost(TreeNode root) {
        while (root != null) {
            lifo.push(root);
            root = root.left;
        }
    }

    // Time complexity O(n) where n is number of left nodes to right node
    // if there is no more right node then O(1)
    public int next() {
        var pop = lifo.pop();

        if (pop.right != null) {
            insertLeftMost(pop.right);
        }

        return pop.val;
    }

    // O(1)
    public boolean hasNext() {
        return !lifo.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */