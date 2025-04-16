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
         var inorder = new ArrayList<TreeNode>();
        inorder(root, inorder);
        for(int i = 0; i < inorder.size() - 1; i++) {
            if(inorder.get(i) == p)
                return inorder.get(i + 1);
        }
        return null;
    }
    
    private void inorder(TreeNode root, ArrayList<TreeNode> inorder) {
        if(root == null)
            return;
        inorder(root.left, inorder);
        inorder.add(root);
        inorder(root.right, inorder);
    }
}