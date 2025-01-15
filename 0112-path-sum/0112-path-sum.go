/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 // Time complexity O(N)
 // Space complexity O(N)
func hasPathSum(root *TreeNode, targetSum int) bool {
	if root == nil {
		return false
	}

	targetSum -= root.Val

	if root.Left == nil && root.Right == nil && targetSum == 0 {
		return true
	}

	return hasPathSum(root.Left, targetSum) ||
		hasPathSum(root.Right, targetSum)
}