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
    // Time complexity O(n) and space complexity O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> response = new ArrayList<>();
        if(root == null)
            return response;

        var leftToRight = true;
        Queue<TreeNode> fifo = new LinkedList<>();
        fifo.add(root);
        while(!fifo.isEmpty()) {
            int size = fifo.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                var current = fifo.poll();
                if(leftToRight) {
                    li.add(current.val);
                } else {
                    li.addFirst(current.val);
                }

                if(current.left != null)
                    fifo.add(current.left);

                if(current.right != null)
                    fifo.add(current.right);
            }
            leftToRight = !leftToRight;
            response.add(li);
        }
        return response;
    }
}