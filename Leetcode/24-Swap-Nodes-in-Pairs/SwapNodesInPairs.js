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
var swapPairs = function(head) {
    if (!head || !head.next) {
        return head
    }
    var dummy = new ListNode(0)
    dummy.next = head
    var A = head
    head = A.next
    var B
    while (A) {
        B = A.next
        if (!B) {
            break
        }
        A.next = B.next
        B.next = A
        dummy.next = B
        dummy = A
        A = A.next
    }
    return head
};
