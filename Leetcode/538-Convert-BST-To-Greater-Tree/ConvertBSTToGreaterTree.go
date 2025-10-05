/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func convertBST(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}
	convert(root, 0)
	return root
}

func convert(node *TreeNode, sum int) int {
	if node == nil {
		return sum
	}
	node.Val += convert(node.Right, sum)
	return convert(node.Left, node.Val)
}
