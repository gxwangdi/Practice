

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
class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        var size = 0;
        var cur = head;
        while (cur!=null) {
            size +=1;
            cur = cur.next;
        }
        var len = size/k;
        var mod = size%k;
        var res = new ListNode[k];
        var index = 0;
        cur = head;
        ListNode prev = null;
        while(index < k) {
            res[index] = cur;
            var temp = 0;
            while (cur != null && temp < len) {
                prev = cur;
                cur = cur.next;
                temp +=1;
            }
            if (cur == null) {
                index++;
                continue;
            }
            if (mod > 0) {
                prev = cur;
                cur = cur.next;
                mod--;
            }
            prev.next = null;
            index +=1;
        }
        // var resHead = cur;
        // System.out.println("size:" + size);
        // System.out.println("mod:" + mod);
        // System.out.println("len:" + len);
        // while (cur!=null && index <k) {
        //     var temp = 1;
        //     resHead = cur;
        //     while (cur!=null && temp < len) {
        //         cur = cur.next;
        //         temp += 1;
        //     }
        //     System.out.println("index:"+index);
        //     if (index < mod && temp != 1) {
        //         cur = cur.next;
        //     }
        //     res[index] = resHead;
        //     if (cur!=null) {
        //         resHead = cur.next;
        //         cur.next = null;
        //         cur = resHead;
        //     }
        //     System.out.println("index:"+index);
        //     System.out.println("cur:"+cur);
        //     index += 1;
        // }
        return res;
    }
}
