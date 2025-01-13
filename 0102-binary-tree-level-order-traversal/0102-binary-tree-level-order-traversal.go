/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    data := make([][]int, 0, 10)

	preorderSolve(root, &data, 0)

	return data
}

func preorderSolve(root *TreeNode, data *[][]int, height int) {
	if root == nil {
		return
	}
	if len(*data) == height {
		*data = append(*data, []int{})
	}
	(*data)[height] = append((*data)[height], root.Val)

	preorderSolve(root.Left, data, height+1)
	preorderSolve(root.Right, data, height+1)
}