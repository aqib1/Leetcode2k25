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
    private final Queue<Integer> fifo;
    public BSTIterator(TreeNode root) {
        this.fifo = new LinkedList<>();
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        fifo.add(root.val);
        inOrder(root.right);
    }
    
    public int next() {
        return fifo.poll();
    }
    
    public boolean hasNext() {
        return !fifo.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */