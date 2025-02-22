/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Time complexity will be O(N)
    // Space complexity will be O(N)


    /**
     - To solve this problem first we will capture all nodes with their parents until p and q is not captured
     - Then we will iterate p and add its all ancestors (backtracking) 
     - Then we will iterate q ancestors until we found a common ancestor between p and q which wil be our result.
     Time complexity O(n) and Space O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parentByChild = new HashMap<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        parentByChild.put(root.val, null);
        // we need to make sure we capture parents of both p and q 
        while(!parentByChild.containsKey(p.val) || !parentByChild.containsKey(q.val)) {
            TreeNode node = bfs.remove();

            if(!Objects.isNull(node.left)) {
                parentByChild.put(node.left.val, node);
                bfs.add(node.left);
            }

            if(!Objects.isNull(node.right)) {
                parentByChild.put(node.right.val, node);
                bfs.add(node.right);
            }
        }

        // capture all of parent from p and store into set until parent is null

        Set<Integer> ancestors = new HashSet<>();

        while(!Objects.isNull(p)) {
            ancestors.add(p.val);
            p = parentByChild.get(p.val);
        }

        // traverse all level of parent of q until we find a common ancestor of p and q 
        while(!Objects.isNull(q) && !ancestors.contains(q.val)) {
            q = parentByChild.get(q.val);
        }

        return q;
    }
}