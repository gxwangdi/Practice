/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    cur1 = l1;
    cur2 = l2;
    dummy = new ListNode(0);
    cur = dummy;
    carry = 0;
    while (cur1 != undefined || cur2 != undefined) {
        if (cur1 != undefined) {
            carry += cur1.val
            cur1 = cur1.next
        }
        
        if (cur2 != undefined) {
            carry += cur2.val
            cur2 = cur2.next
        }
        
        temp = new ListNode(carry % 10)
        cur.next = temp;
        cur = cur.next;
        carry = Math.floor(carry / 10)
    }
    if (carry != 0) {
        temp = new ListNode(carry);
        cur.next = temp
        cur = cur.next
    }
    return dummy.next
};

