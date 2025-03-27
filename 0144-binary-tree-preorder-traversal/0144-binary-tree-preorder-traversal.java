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
    public List<Integer> preorderTraversal(TreeNode root) {
        var response = new ArrayList<Integer>();
        preorder(root, response);
        return response;
    }
    
    public void preorder(TreeNode root, ArrayList<Integer> response) {
        if(root == null)
            return;
        
        response.add(root.val);
        preorder(root.left, response);
        preorder(root.right, response);
        
    }
}