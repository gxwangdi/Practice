/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	len := getLength(head)
	k = k % len
	if k == 0 {
		return head
	}
	dummy := &ListNode{Val: 0, Next: head}
	fast := dummy
	for k > 0 {
		fast = fast.Next
		k -= 1
	}
	slow := dummy
	for fast.Next != nil {
		slow = slow.Next
		fast = fast.Next
	}
	dummy.Next = slow.Next
	slow.Next = nil
	fast.Next = head
	return dummy.Next
}

func getLength(head *ListNode) int {
	cur := head
	len := 0
	for cur != nil {
		cur = cur.Next
		len += 1
	}
	return len
}
