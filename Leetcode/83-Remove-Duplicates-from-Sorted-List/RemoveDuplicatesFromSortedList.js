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
    var cur = head
    var nextVal
    while (cur && cur.next) {
        nextVal = cur.next
        while (nextVal && nextVal.val == cur.val) {
            nextVal = nextVal.next
        }
        cur.next = nextVal
        cur = cur.next
    }
    return head
};

