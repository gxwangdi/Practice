/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function(head, m, n) {
    if (!head || n<=m) {
        return head
    }
    var dummy = new ListNode(0)
    dummy.next = head
    var cur = dummy
    var i
    for (i=0; i+1<m; i++) {
        if (cur) {
            cur = cur.next
        }
    }
    var prev = cur
    var n1;
    if (prev) {
        n1 = prev.next;
    }
    var n2;
    if (n1) {
        n2 = n1.next
    }
    var range = n-m
    while (range >0 && n2) {
        var temp = n2.next
        n2.next = n1;
        n1 = n2;
        n2 = temp;
        range--;
    }
    if (prev && prev.next) {
        prev.next.next = n2
        prev.next = n1
    }
    return dummy.next
};

