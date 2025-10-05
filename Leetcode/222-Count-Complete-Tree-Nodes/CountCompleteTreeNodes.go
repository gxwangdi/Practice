/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func countNodes(root *TreeNode) int {
	h := height(root)
	if h < 0 {
		return 0
	} else {
		if height(root.Right) == h-1 {
			return (1 << uint(h)) + countNodes(root.Right)
		} else {
			return (1 << uint(h-1)) + countNodes(root.Left)
		}
	}
}

func height(node *TreeNode) int {
	if node == nil {
		return -1
	} else {
		return 1 + height(node.Left)
	}
}
