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
    public boolean isValidBST(TreeNode root) {     
       var inOrder = new ArrayList<Integer>();
        inOrder(root, inOrder);

        for(int i = 0; i < inOrder.size() - 1; i++) {
            if(inOrder.get(i + 1) <= inOrder.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> inOrder) {
        if(root == null)
            return;
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }
}