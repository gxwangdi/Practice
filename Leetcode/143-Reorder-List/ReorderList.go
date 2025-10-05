/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode) {
	if head == nil || head.Next == nil {
		return
	}
	p1 := head
	p2 := head.Next
	for p2 != nil && p2.Next != nil {
		p1, p2 = p1.Next, p2.Next.Next
	}
	head2 := p1.Next
	p1.Next = nil
	p2 = head2.Next
	head2.Next = nil
	for p2 != nil {
		// p1, p2.Next, head2, p2 = p2.Next, head2, p2, p1
		p1 = p2.Next
		p2.Next = head2
		head2 = p2
		p2 = p1
	}
	p1 = head
	p2 = head2
	for p1 != nil {
		temp := p1.Next
		p1, p1.Next, p2 = p2, p2, temp
	}
}
