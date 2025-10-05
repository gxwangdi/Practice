/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func oddEvenList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	o := head
	e := head.Next
	eHead := head.Next
	for e != nil && e.Next != nil {
		o.Next = e.Next
		e.Next = e.Next.Next
		o = o.Next
		e = e.Next
	}
	o.Next = eHead
	return head
}
