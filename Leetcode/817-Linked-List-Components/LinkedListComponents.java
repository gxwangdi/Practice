

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
class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        var set = new HashSet<Integer>(Arrays.stream(nums).boxed().toList());
        var cur = head;
        var res = 0;
        var match = false;
        while (cur != null) {
            if (match && set.contains(cur.val)) {
                cur = cur.next;
                continue;
            }
            if (match && !set.contains(cur.val)) {
                match =false;
                cur = cur.next;
                continue;
            }
            if (!match && set.contains(cur.val)) {
                res +=1;
                match = true;
                cur = cur.next;
                continue;
            }
            if (!match && !set.contains(cur.val)) {
                cur = cur.next;
                continue;
            }
        }
        return res;
    }
}
