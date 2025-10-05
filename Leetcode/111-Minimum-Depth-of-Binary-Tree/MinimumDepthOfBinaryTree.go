/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */import "math"

func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return getMin(root)
}

func getMin(node *TreeNode) int {
	if node == nil {
		return math.MaxInt64
	}
	if node.Left == nil && node.Right == nil {
		return 1
	}
	return min(getMin(node.Left), getMin(node.Right)) + 1
}

func min(i1, i2 int) int {
	if i1 <= i2 {
		return i1
	}
	return i2
}
