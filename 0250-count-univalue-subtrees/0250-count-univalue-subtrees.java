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

    private int count;
    public int countUnivalSubtrees(TreeNode root) {
       countUntil(root);
       return count;
    }

    public boolean countUntil(TreeNode root) {
        if(root == null) 
            return true;

        boolean left = countUntil(root.left);
        boolean right = countUntil(root.right);

        if(left && right) {
            if(root.left != null && root.val != root.left.val) {
                return false;
            }

            if(root.right != null && root.val != root.right.val) {
                return false;
            }

            count++;
            return true;

        } else {
            return false;
        }    
    }
}