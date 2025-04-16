/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return successor(root, p);
    }
    
    public TreeNode successor(TreeNode root, TreeNode p) {
        TreeNode succssor = null;
        
        while (root != null) {
            if(p.val < root.val) {
                succssor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return succssor;
    }
}