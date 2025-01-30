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
    private int[] postorder;
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorderIndex = new HashMap<>();
        this.postorder = postorder;
        postorderIndex = postorder.length - 1;
        int index = 0;
        for(int in : inorder) inorderIndex.put(in, index++);

        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right)
            return null;

        TreeNode rootNode = new TreeNode(postorder[postorderIndex--]);
        int rootIndex = inorderIndex.get(rootNode.val);
        rootNode.right = helper(rootIndex + 1, right);
        rootNode.left = helper(left, rootIndex - 1);
        return rootNode;
    }
}