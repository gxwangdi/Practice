/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func diameterOfBinaryTree(root *TreeNode) int {
	res := getDiameter(root)
	return res[0]
}

func getDiameter(node *TreeNode) [2]int {
	res := [2]int{0, 0}
	if node == nil {
		return res
	}
	left := getDiameter(node.Left)
	right := getDiameter(node.Right)
	res[0] = max(left[1]+right[1], max(left[0], right[0]))
	res[1] = max(left[1], right[1]) + 1
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
