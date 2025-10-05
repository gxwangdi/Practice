/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
        {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sHead = slow.next;
        slow.next = null;

        // reverse sHead list.
        ListNode p1 = sHead;
        ListNode p2 = p1.next;
        while (p1!=null && p2!=null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        sHead.next = null;

        // compare head and sHead
        ListNode p= (p2==null)?p1:p2;
        ListNode q= head;
        while (p!=null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    /*  // Time O(n)  Space O(n)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode cur = head;
        ListNode reverse = new ListNode(head.val);

        while (cur.next!=null) {
            ListNode n = new ListNode(cur.next.val);
            n.next = reverse;
            reverse = n;
            cur = cur.next;
        }

        cur = head;
        while (cur!=null) {
            if (cur.val != reverse.val)
                return false;
            cur = cur.next;
            reverse = reverse.next;
        }
        return true;
    }*/
}
