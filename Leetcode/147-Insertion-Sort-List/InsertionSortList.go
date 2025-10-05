/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func insertionSortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	dummy := &ListNode{Val: head.Val}
	for head != nil {
		temp := head
		head = head.Next
		temp.Next = nil
		n := dummy
		for n.Next != nil {
			if temp.Val < n.Next.Val {
				break
			}
			n = n.Next
		}
		temp.Next = n.Next
		n.Next = temp
	}
	return dummy.Next
}
