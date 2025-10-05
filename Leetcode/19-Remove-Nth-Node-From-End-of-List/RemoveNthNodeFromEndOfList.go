/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	if head == nil || n < 0 {
		return nil
	}
	dummy := &ListNode{Val: 0, Next: head}
	prev := dummy
	target := head
	tail := head
	i := 0
	for i < n && tail != nil {
		tail = tail.Next
		i++
	}
	for tail != nil {
		tail = tail.Next
		target = target.Next
		prev = prev.Next
	}
	prev.Next = target.Next
	return dummy.Next
}
