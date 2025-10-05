/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}
	dummy := new(ListNode)
	dummy.Next = head
	cur := dummy
	for cur != nil {
		ite := cur.Next
		exists := false
		for ite != nil && ite.Val == val {
			exists = true
			ite = ite.Next
		}
		if exists {
			cur.Next = ite
		}
		cur = ite
	}
	return dummy.Next
}
