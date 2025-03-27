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
    public List<Integer> inorderTraversal(TreeNode root) {
        var response = new ArrayList<Integer>();
        inorder(root, response);
        return response;
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> response) {
        if(root == null)
            return;
        
        inorder(root.left, response);
        response.add(root.val);
        inorder(root.right, response);
        
    }
}