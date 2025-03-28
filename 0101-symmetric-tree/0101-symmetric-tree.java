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
class Solution {
    public boolean isSymmetric(TreeNode root) {
       if (root == null)
            return false;
        Queue<TreeNode> fifo = new LinkedList<>();
        fifo.add(root.left);
        fifo.add(root.right);

        while (!fifo.isEmpty()) {
            var left = fifo.poll();
            var right = fifo.poll();

            if (left == null && right == null)
                continue;

            if(left == null || right == null)
                return false;

            if (left.val != right.val)
                return false;

            fifo.add(left.left);
            fifo.add(right.right);
            fifo.add(left.right);
            fifo.add(right.left);
        }

        return true;
    }
}