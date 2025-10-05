/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if (!head || !head.next) {
        return head
    }
    var dummy = new ListNode(0)
    dummy.next = head
    var cur = dummy
    var isDup = false
    while (cur && cur.next) {
        if (cur.next.next && cur.next.val == cur.next.next.val) {
            isDup = true
            cur.next.next = cur.next.next.next
        } else {
            if (isDup) {
                isDup = false
                cur.next = cur.next.next
            } else {
                cur = cur.next
            }
        }
    }
    return dummy.next
};
