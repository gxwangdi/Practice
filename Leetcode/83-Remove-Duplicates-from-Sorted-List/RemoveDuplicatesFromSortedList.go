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
	cur := head
	for cur != nil && cur.Next != nil {
		nextVal := cur.Next
		for nextVal != nil && nextVal.Val == cur.Val {
			nextVal = nextVal.Next
		}
		cur.Next = nextVal
		cur = cur.Next
	}
	return head
}
