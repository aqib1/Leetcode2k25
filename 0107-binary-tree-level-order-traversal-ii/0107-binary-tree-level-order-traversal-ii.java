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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        levelOrderStorage(root, levelOrder, 0);
        return levelOrder;
    }

    private void levelOrderStorage(
            TreeNode root,
            List<List<Integer>> levelOrder,
            int level
    ) {
        if (root == null) return;
        if(level >= levelOrder.size()) levelOrder.addFirst(new ArrayList<>());

        levelOrder.get(levelOrder.size() - 1 - level).add(root.val);

        levelOrderStorage(root.left, levelOrder, level + 1);
        levelOrderStorage(root.right, levelOrder, level + 1);
    }
}