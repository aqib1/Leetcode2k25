/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
    data := make([]int, 0, 10)
	preorder(root, &data)
	return data
}

func preorder(root *TreeNode, data *[]int) {
	if root == nil {
		return
	}
    
	*data = append(*data, root.Val)
	
    preorder(root.Left, data)
	preorder(root.Right, data)
}