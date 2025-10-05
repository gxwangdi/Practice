/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if (!head || n<0) {
        return null
    }
    let dummy = new ListNode(0)
    dummy.next = head
    var prev = dummy
    var target = head
    var tail = head
    var i
    for (i=0; i<n && tail; i++) {
        tail = tail.next
    }
    while (tail) {
        tail = tail.next
        target = target.next
        prev = prev.next
    }
    prev.next = target.next
    return dummy.next
};


