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
var oddEvenList = function(head) {
    if (!head) {
        return head
    }

    var o = head
    var e = head.next
    var eHead = head.next
    while (e && e.next) {
        o.next = e.next
        e.next = e.next.next
        o = o.next
        e = e.next
    }
    o.next = eHead
    return head
};
