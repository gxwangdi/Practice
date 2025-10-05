/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    if (!head || !head.next) {
        return true
    }

    var slow = head
    var fast = head
    while (fast.next && fast.next.next) {
        slow = slow.next
        fast = fast.next.next
    }
    var sHead = slow.next
    slow.next = null;

    // reverse sHead list
    var p1 = sHead
    var p2 = p1.next
    while (p1 && p2) {
        var temp = p2.next
        p2.next = p1
        p1 = p2
        p2= temp
    }
    sHead.next = null

    // compare head and sHead
    var p = p2? p2:p1
    var q = head
    while (p) {
        if (p.val != q.val) {
            return false
        }
        p = p.next
        q = q.next
    }
    return true
};
