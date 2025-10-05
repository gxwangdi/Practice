
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
	/**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lenA = 0;
        int lenB = 0;
        ListNode cur = headA;
        while (cur!=null) {
            cur = cur.next;
            lenA++;
        }
        cur = headB;
        while (cur!=null) {
            cur = cur.next;
            lenB++;
        }
        int diff = Math.abs(lenB - lenA);
        ListNode longer;
        ListNode shorter;
        if (lenA >= lenB) {
            longer = headA;
            shorter = headB;
        } else {
            longer = headB;
            shorter = headA;
        }
        while (diff>0) {
            longer = longer.next;
            diff--;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter= shorter.next;
        }
        return longer;
    }
}
