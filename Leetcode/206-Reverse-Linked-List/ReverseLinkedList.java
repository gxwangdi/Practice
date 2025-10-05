/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class ReverseLinkedList {
    /*
    // Recursive approach
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = null;
        return reverse(head, tail);
    }
    
    private ListNode reverse(ListNode node, ListNode tail) {
        if (node == null) {
            return tail;
        }
        ListNode next = node.next;
        node.next = tail;
        return reverse(next, node);
    }
    */
    
    // Iterataive approach.
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode n1 = head;
        ListNode n2 = n1.next;
        n1.next = null;
        while (n2 != null) {
            ListNode temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }// end of reverseList 
    
}




