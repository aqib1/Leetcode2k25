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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            var current = bfs.poll();
            int diff = Math.abs(height(current.left) - height(current.right));
            if(diff > 1) {
                return false;
            }

            if(current.left != null) bfs.add(current.left);
            if(current.right != null) bfs.add(current.right);
        }

        return true;
    }

    public int height(TreeNode root) {
        if(root == null)
            return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}