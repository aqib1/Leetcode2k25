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
import java.util.HashMap;
import java.util.Map;
class Solution {
 private Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for (int x = 0; x < inorder.length; x++) {
			inOrderIndexMap.put(inorder[x], x);
		}
		return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
	}

private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end, int postOrderIndex) {
		if (start > end || postOrderIndex < 0)
			return null;
		TreeNode node = new TreeNode(postorder[postOrderIndex]);
		if (start == end)
			return node;
		int indexOfInOrder = inOrderIndexMap.get(node.val);
		node.left = buildTree(inorder, postorder, start, indexOfInOrder - 1,
				(postOrderIndex + indexOfInOrder) - end - 1);
		node.right = buildTree(inorder, postorder, indexOfInOrder + 1, end, postOrderIndex - 1);
		return node;
	}
}