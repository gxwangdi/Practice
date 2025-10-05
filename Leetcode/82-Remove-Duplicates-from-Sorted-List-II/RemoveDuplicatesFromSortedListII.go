/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	dummy := new(ListNode)
	dummy.Next = head
	cur := dummy
	isDup := false
	for cur != nil && cur.Next != nil {
		if cur.Next.Next != nil && cur.Next.Val == cur.Next.Next.Val {
			isDup = true
			cur.Next.Next = cur.Next.Next.Next
		} else {
			if isDup {
				isDup = false
				cur.Next = cur.Next.Next
			} else {
				cur = cur.Next
			}
		}
	}
	return dummy.Next
}
