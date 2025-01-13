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
    preorder(root, &data, 0)  
  return data
}

func preorder(root *TreeNode, data *[][]int, height int) {
    if root == nil {
        return
    }

    if len(*data) == height {
        *data = append(*data, []int{})
    }

    (*data)[height] = append((*data)[height], root.Val)
    preorder(root.Left, data, height + 1)
    preorder(root.Right, data, height + 1)
}
