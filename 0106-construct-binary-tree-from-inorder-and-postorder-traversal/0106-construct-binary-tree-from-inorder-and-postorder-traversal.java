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
    private Map<Integer, Integer> inorderWithIndex;
    private int postorderIndex;

    // LRN
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorderWithIndex = new HashMap<>();
        this.postorder = postorder;
        this.postorderIndex = postorder.length - 1;
        int index = 0;
        for(int i: inorder) inorderWithIndex.put(i, index++);
        return helper(0, postorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right)
            return null;
        var root = new TreeNode(postorder[postorderIndex--]);
        int rootIndex = this.inorderWithIndex.get(root.val);
        root.right = helper(rootIndex + 1, right);
        root.left = helper(left, rootIndex - 1);
        return root;
    }
}