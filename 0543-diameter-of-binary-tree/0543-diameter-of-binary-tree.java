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
    private int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
         d = 0;
        find(root);
        return d;
    }

    public int find(TreeNode root) {
        if(root == null)
            return 0;

        int left = find(root.left);
        int right = find(root.right);
        d = Math.max(d, left + right);

        return Math.max(left, right) + 1;
    }
}