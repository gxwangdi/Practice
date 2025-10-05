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
var reverseList = function(head) {
    if (head == undefined || head.next == undefined) {
        return head
    }
    
    var n1 = head
    var n2 = n1.next
    n1.next = undefined
    while (n2 != undefined) {
        var temp = n2.next
        n2.next = n1
        n1 = n2
        n2 = temp
    }
    return n1
};

