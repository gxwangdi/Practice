/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func searchBST(root *TreeNode, val int) *TreeNode {
	cur := root
	for cur != nil {
		if cur.Val == val {
			break
		}
		if cur.Val > val {
			cur = cur.Left
			continue
		}
		cur = cur.Right
	}
	return cur
}
