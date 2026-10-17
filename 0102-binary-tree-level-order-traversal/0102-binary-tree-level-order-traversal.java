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
    public List<List<Integer>> levelOrder(TreeNode treeNode) {
       if(treeNode == null)
            return new ArrayList<>();
        List<List<Integer>> response = new ArrayList<>();
        levelOrder(treeNode, 0, response);
        return response;
    }

    public static void levelOrder(TreeNode treeNode, int level, List<List<Integer>> response) {
        if(treeNode == null)
            return;
        if (level == response.size())
            response.add(new ArrayList<>());

        response.get(level).add(treeNode.val);
        levelOrder(treeNode.left, level + 1, response);
        levelOrder(treeNode.right, level + 1, response);
    }
}