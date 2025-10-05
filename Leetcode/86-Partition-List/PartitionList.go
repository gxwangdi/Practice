/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
	cur := head

	leftDummy := &ListNode{Val: 0}
	leftCur := leftDummy

	rightDummy := &ListNode{Val: 0}
	rightCur := rightDummy

	for cur != nil {
		if cur.Val < x {
			leftCur.Next = cur
			cur = cur.Next
			leftCur = leftCur.Next
			leftCur.Next = nil
		} else {
			rightCur.Next = cur
			cur = cur.Next
			rightCur = rightCur.Next
			rightCur.Next = nil
		}
	}
	leftCur.Next = rightDummy.Next
	return leftDummy.Next
}
