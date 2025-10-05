
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class NthToLastNodeInList {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (first != null && n > 0) {
            first = first.next;
            n--;
        }
        if (n > 0) {
            return null;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;  
    }
}
