/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func postorderTraversal(root *TreeNode) []int {
    data := make([]int, 0, 10)
	postorder(root, &data)
	return data
}

func postorder(root *TreeNode, data *[]int) {
	if root == nil {
		return
	}

	postorder(root.Left, data)
	postorder(root.Right, data)

	*data = append(*data, root.Val)
}