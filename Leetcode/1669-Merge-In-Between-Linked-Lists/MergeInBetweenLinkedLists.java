

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;
        // a>0, b>0, a<b<list1.length,
        var aNode = dummy;
        for(int i=0; i<a; i++) {
            aNode = aNode.next;
        }
        var bNode = aNode;
        for(int i=b-a; i>=0; i--) {
            bNode = bNode.next;
        }
        aNode.next = list2;
        while(aNode.next!=null) {
            aNode = aNode.next;
        }
        aNode.next = bNode.next;
        return dummy.next;
    }
}
