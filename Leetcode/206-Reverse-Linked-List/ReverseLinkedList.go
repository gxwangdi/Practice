/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	n1 := head
	n2 := n1.Next
	n1.Next = nil
	for n2 != nil {
		n2.Next, n1, n2 = n1, n2, n2.Next
	}
	return n1
}
