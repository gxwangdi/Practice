
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func max(i1, i2 int) int {
	if i1 >= i2 {
		return i1
	}
	return i2
}

func abs(i int) int {
	if i >= 0 {
		return i
	}
	return -i
}

func getHeight(node *TreeNode) int {
	if node == nil {
		return 0
	}
	left := getHeight(node.Left)
	right := getHeight(node.Right)
	if left == -1 || right == -1 {
		return -1
	}
	if abs(left-right) > 1 {
		return -1
	}
	return max(left, right) + 1
}

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	if getHeight(root) == -1 {
		return false
	}
	return true
}
