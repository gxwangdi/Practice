
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class AddTwoNumbers {
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode sumHead = null;
        ListNode curSum = null;
        while (cur1 != null || cur2 != null)  {
            if (cur1 != null) {
                carry += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                carry += cur2.val;
                cur2 = cur2.next;
            }
            if (sumHead == null) {
                sumHead = new ListNode(carry >= 10 ? carry - 10 : carry);
                curSum = sumHead;
                carry = carry / 10;
                continue;
            }
            curSum.next = new ListNode(carry >= 10 ? carry - 10 : carry);
            curSum = curSum.next;
            carry = carry / 10;
        }
        // Assuming l1 and l2 are of the same length.
        if (carry != 0) {
            curSum.next = new ListNode(carry);
            curSum = curSum.next;
        }
        return sumHead;
    }// end of addLists
}


