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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> response = new ArrayList<>();
        var currentLevel = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            var size = q.size();
            response.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                var curr = q.poll();
                if (curr != null) {
                    response.get(currentLevel).add(curr.val);

                    if (curr.left != null)
                        q.offer(curr.left);
                    if (curr.right != null)
                        q.offer(curr.right);
                }
            }
            currentLevel++;
        }
        return response;
    }
}