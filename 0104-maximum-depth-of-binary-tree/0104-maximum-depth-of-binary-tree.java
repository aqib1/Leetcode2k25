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
    private int depth;
    public int maxDepth(TreeNode root) {
        findDepthUsingTopDown(root, 1);
        return depth;
    }
    
    private void findDepthUsingTopDown(TreeNode root, int depth) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            this.depth = Math.max(this.depth, depth);
        }
        findDepthUsingTopDown(root.left, depth + 1);
        findDepthUsingTopDown(root.right, depth + 1);
    }
}