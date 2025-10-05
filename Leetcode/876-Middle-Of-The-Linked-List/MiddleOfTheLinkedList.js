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
var middleNode = function(head) {
    if (!head || !head.next) {
        return head
    }
    var slow = head
    var fast = head
    while (fast && fast.next) {
        slow = slow.next
        fast = fast.next.next
    }
    return slow
};
