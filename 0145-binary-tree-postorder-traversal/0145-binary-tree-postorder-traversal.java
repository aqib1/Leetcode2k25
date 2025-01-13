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
        var postorder = new ArrayList<Integer>();
        postorderResult(root, postorder);
        return postorder;
    }
    
    public void postorderResult(TreeNode root, List<Integer> postorder) {
        if(root == null)
            return;
        
        postorderResult(root.left, postorder);
        postorderResult(root.right, postorder);
        postorder.add(root.val);
    }
}