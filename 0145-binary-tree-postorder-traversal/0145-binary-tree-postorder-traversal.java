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
    public List<Integer> postorderTraversal(TreeNode root) {
        var response = new ArrayList<Integer>();
        postorderTraversal(root, response);
        return response;
    }
    
    public void postorderTraversal(TreeNode root, ArrayList<Integer> response) {
        if(root == null)
            return;
        
      postorderTraversal(root.left, response);
      postorderTraversal(root.right, response);
      response.add(root.val);  
    }
}