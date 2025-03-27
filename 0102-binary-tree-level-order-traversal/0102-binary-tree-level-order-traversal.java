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
    // Time complexity O(N) where N is number of nodes in tree and space O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> response = new ArrayList<>();
        preOrder(root, 0, response);
        return response;
    }
    
    public static void preOrder(TreeNode root, int height, List<List<Integer>> res) {
        if(root == null)
            return;

        if(res.size() == height)
            res.add(new ArrayList<>());

        res.get(height).add(root.val);

        preOrder(root.left, height + 1, res);
        preOrder(root.right, height + 1, res);
    }
}