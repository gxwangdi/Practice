/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseBetween(head *ListNode, m int, n int) *ListNode {
	if head == nil || n <= m {
		return head
	}
	var dummy *ListNode
	dummy = &ListNode{Val: 0, Next: head}
	cur := dummy
	i := 0
	for i+1 < m {
		if cur != nil {
			cur = cur.Next
		}
		i++
	}
	prev := cur
	var n1 *ListNode
	if prev != nil {
		n1 = prev.Next
	}
	var n2 *ListNode
	if n1 != nil {
		n2 = n1.Next
	}
	var ran = n - m
	for ran > 0 && n2 != nil {
		n2.Next, n1, n2 = n1, n2, n2.Next
		ran--
	}
	if prev != nil && prev.Next != nil {
		prev.Next.Next = n2
		prev.Next = n1
	}
	return dummy.Next
}
