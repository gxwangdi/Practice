/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var tilt int

func findTilt(root *TreeNode) int {
	tilt = 0
	postOrder(root)
	return tilt
}

func postOrder(node *TreeNode) int {
	if node == nil {
		return 0
	}
	left := postOrder(node.Left)
	right := postOrder(node.Right)
	tilt += abs(left - right)
	return left + right + node.Val
}

func abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}
