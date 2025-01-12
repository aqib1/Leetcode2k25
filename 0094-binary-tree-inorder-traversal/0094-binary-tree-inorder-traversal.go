/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 // Time complexity O(n)
 // Space complexity OLog(n)
func inorderTraversal(root *TreeNode) []int {
    data := make([]int, 0, 10)
	inorder(root, &data)
	return data
}

func inorder(root *TreeNode, data *[]int) {
	if root == nil {
		return
	}

	inorder(root.Left, data)
	*data = append(*data, root.Val)
	inorder(root.Right, data)
}