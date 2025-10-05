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
var insertionSortList = function(head) {
    if (!head || !head.next) {
        return head
    }
    var dummy = new ListNode(head.val)
    var temp
    while (head) {
        temp = head
        head = head.next
        temp.next = null
        var n = dummy
        while (n.next) {
            if (temp.val < n.next.val) {
                break;
            }
            n = n.next
        }
        temp.next = n.next;
        n.next = temp
    }
    return dummy.next
};
