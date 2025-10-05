/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    if (!head) {
        return head
    }
    var dummy = new ListNode(0)
    dummy.next = head
    var cur = dummy
    while (cur) {
        var ite = cur.next
        var exists = false
        while (ite && ite.val == val) {
            exists = true
            ite = ite.next
        }
        if (exists) {
            cur.next = ite
        }
        cur = ite
    }
    return dummy.next
};
