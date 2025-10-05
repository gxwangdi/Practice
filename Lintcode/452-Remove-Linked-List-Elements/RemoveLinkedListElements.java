/*
 Remove all elements from a linked list of integers that have value val.
 
 Example
Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5    
 * */



public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
}



