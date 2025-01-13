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
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        postOrder(root, result, 0);
        return result;
    }

    private void postOrder(TreeNode root, List<List<Integer>> result, int height) {
        if(root == null)
            return;
        if(result.size() == height)
            result.add(new ArrayList<>());

        result.get(height).add(root.val);

        postOrder(root.left, result, height + 1);
        postOrder(root.right, result, height + 1);
    }
}