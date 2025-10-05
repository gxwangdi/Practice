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


public class IntersectionOfTwoLinkedLists {
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
    
        ListNode a = headA;
        ListNode b = headB;
        while( a != b){
    	    //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        return a;
     }
     /*
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (curA!=null) {
            curA = curA.next;
            lengthA++;
        }
        while (curB!=null) {
            curB = curB.next;
            lengthB++;
        }
        ListNode llist;
        ListNode slist;
        if (lengthA >= lengthB) {
            llist = headA;
            slist = headB;
        } else {
            llist = headB;
            slist = headA;
        }
        int dis = Math.abs(lengthA - lengthB);
        for (int i=0; i<dis; i++) {
            llist = llist.next;
        }
        
        while (llist != slist) {
            llist = llist.next;
            slist = slist.next;
        }
        return llist;
    }*/
}
