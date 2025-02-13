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
    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorderIndexMap = new HashMap<>();
        this.preorder = preorder;
        int index = 0;
        for(int i: inorder) inorderIndexMap.put(i, index++);

        return helper(0, preorder.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if(left > right) {
            return null;
        }

        TreeNode root = new TreeNode(
                preorder[preorderIndex++]
        );

        int rootIndex = inorderIndexMap.get(root.val);
        root.left = helper(left, rootIndex - 1);
        root.right = helper(rootIndex + 1, right);
        
        return root;
    }
}