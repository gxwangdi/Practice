/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
var partition = function(head, x) {
    var cur = head
    var leftDummy = new ListNode(0)
    var leftCur = leftDummy
    var rightDummy = new ListNode(0)
    var rightCur = rightDummy
    while (cur) {
        if (cur.val<x) {
            leftCur.next = cur
            cur=cur.next
            leftCur=leftCur.next
            leftCur.next = null
        } else {
            rightCur.next = cur
            cur = cur.next
            rightCur = rightCur.next
            rightCur.next = null
        }
    }
    leftCur.next = rightDummy.next
    return leftDummy.next
};
