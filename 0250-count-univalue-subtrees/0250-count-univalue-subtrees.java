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
    public Solution() {
        count = 0;
    }

    public int countUnivalSubtrees(TreeNode root) {
        countUni(root);
        return count;
    }

    private boolean countUni(TreeNode root) {
        if(root == null)
            return true;

        boolean left = countUni(root.left);
        boolean right = countUni(root.right);

        if(left && right) {
            if((root.left != null && root.val != root.left.val)
                            || (root.right != null && root.val != root.right.val)) {
                return false;
            }

            count++;
            return true;
        } else {
            return false;
        }
    }
}