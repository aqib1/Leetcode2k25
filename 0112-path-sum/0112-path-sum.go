/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func hasPathSum(root *TreeNode, targetSum int) bool {
    return hasPathSumRec(root, targetSum, 0)
}

func hasPathSumRec(root *TreeNode, target int, current int) bool {
	if root == nil {
		return false
	}

	sum := root.Val + current

	if root.Left == nil && root.Right == nil && target == sum {
		return true
	}
    
	return hasPathSumRec(root.Left, target, sum) ||
		hasPathSumRec(root.Right, target, sum)
}