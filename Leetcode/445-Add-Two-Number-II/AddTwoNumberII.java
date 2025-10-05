
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
class AddTwoNumberII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var h1 = reverse(l1);
        var h2 = reverse(l2);
        System.out.println("h1:" + h1.val);
        System.out.println("h2:" + h2.val);
        var dummy = new ListNode();
        var cur = dummy;
        var bit = 0;
        while (h1 != null || h2 != null) {
            var sum = bit;
            if (h1 !=null) {
                sum += h1.val;
                h1 = h1.next;
            }
            if (h2 !=null) {
                sum += h2.val;
                h2 = h2.next;
            }
            bit = sum / 10;
            sum = sum%10;
            cur.next = new ListNode(sum);
            System.out.println("cur:" + cur.val);
            cur = cur.next;
        }
        if (bit != 0) {
            cur.next = new ListNode(bit);
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        var h1 = head;
        var p1 = h1.next;
        h1.next = null;
        while (p1!=null) {
            var temp = p1.next;
            p1.next = h1;
            h1 = p1;
            p1 = temp;
        }
        return h1;
    }
}
