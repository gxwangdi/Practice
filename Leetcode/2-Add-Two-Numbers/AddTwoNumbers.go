/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    cur1 := l1
    cur2 := l2
    dummy := &ListNode{Val : 0, Next : nil}
    cur := dummy
    carry := 0
    for cur1 != nil || cur2 != nil {
        if cur1 != nil {
            carry += cur1.Val
            cur1 = cur1.Next
        }

        if cur2 != nil {
            carry += cur2.Val
            cur2 = cur2.Next
        }

        temp := &ListNode{Val : carry%10, Next : nil}
        cur.Next = temp
        cur = cur.Next
        carry = carry / 10
    }
    if carry != 0 {
        temp := &ListNode{Val : carry, Next : nil}
        cur.Next = temp
        cur = cur.Next
    }
    return dummy.Next
}
