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
    
    public TreeNode successor(TreeNode node, TreeNode p) {
       TreeNode successor = null;
       while(node != null) {
           if(p.val < node.val) {
               successor = node;
               node = node.left;
           } else {
               node = node.right;
           }
       }
       return successor;
    }
}