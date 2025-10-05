/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function(head, k) {
    if (!head || !head.next) {
        return head
    }
    var getLength = function(head) {
        var cur = head
        var len = 0
        while (cur) {
            cur = cur.next
            len++
        }
        return len
    }
    var len = getLength(head);
    k = k%len
    if (k==0) {
        return head
    }
    var dummy = new ListNode(0)
    dummy.next = head
    fast = dummy
    while (k>0) {
        fast = fast.next
        k--;
    }
    var slow = dummy
    while (fast.next) {
        slow = slow.next
        fast = fast.next
    }
    dummy.next = slow.next
    slow.next = null
    fast.next = head
    return dummy.next
};
