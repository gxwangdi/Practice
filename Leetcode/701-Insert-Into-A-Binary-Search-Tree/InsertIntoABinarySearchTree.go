/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func insertIntoBST(root *TreeNode, val int) *TreeNode {
	node := &TreeNode{Val: val}
	if root == nil {
		root = node
		return root
	}
	cur := root
	for true {
		if cur.Val > val {
			if cur.Left == nil {
				cur.Left = node
				break
			}
			cur = cur.Left
			continue
		}
		if cur.Right == nil {
			cur.Right = node
			break
		}
		cur = cur.Right
	}
	return root
}
