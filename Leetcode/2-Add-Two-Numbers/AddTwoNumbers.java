/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (cur1!=null || cur2!=null) {
            if (cur1!= null) {
                carry += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2!= null) {
                carry += cur2.val;
                cur2 = cur2.next;
            }
            ListNode temp = new ListNode(carry%10);
            cur.next = temp;
            cur = cur.next;
            carry = carry/10;
        }
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
}





