/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	dummy := &ListNode{Val: 0, Next: nil}
	dummy.Next = head
	A := head
	head = A.Next
	var B *ListNode
	for A != nil {
		B = A.Next
		if B == nil {
			break
		}
		A.Next = B.Next
		B.Next = A
		dummy.Next = B
		dummy = A
		A = A.Next
	}
	return head
}
