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
    private int[] preorder;
    private int preorderIndex;
    private Map<Integer, Integer> inorderMap;
    // Pre Order = NLR (construct left first)
    // Space complexity O(n)
    // Time complexity O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int inorderIndex = 0;
        this.inorderMap = new HashMap<>();
        for(int in : inorder) inorderMap.put(in, inorderIndex++);

        return helper(0, preorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right)
            return null;
        TreeNode root = new TreeNode(this.preorder[preorderIndex++]);
        int rootIndex = inorderMap.get(root.val);
        root.left = helper(left, rootIndex - 1);
        root.right = helper(rootIndex + 1, right);
        return root;
    }
}