/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	slow := head
	fast := head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	sHead := slow.Next
	slow.Next = nil

	// reverse sHead list
	p1 := sHead
	p2 := p1.Next
	for p1 != nil && p2 != nil {
		p2.Next, p1, p2 = p1, p2, p2.Next
	}
	sHead.Next = nil

	// compare head and sHead
	p := p2
	if p2 == nil {
		p = p1
	}
	q := head
	for p != nil {
		if p.Val != q.Val {
			return false
		}
		p = p.Next
		q = q.Next
	}
	return true
}
