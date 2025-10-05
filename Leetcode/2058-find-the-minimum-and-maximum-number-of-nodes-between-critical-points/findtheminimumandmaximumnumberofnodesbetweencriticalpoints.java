

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
class findtheminimumandmaximumnumberofnodesbetweencriticalpoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        var res = new int[]{-1,-1};
        var p1 = head;
        if (p1.next == null || p1.next.next == null) {
            return res;
        }
        var minI = -1;
        var maxI = -1;
        var minD = Integer.MAX_VALUE;
        var curI = 0;
        while (p1.next.next!=null) {
            if (isCritical(p1, p1.next.next)) {
                if (minI == -1) {
                    minI = curI;
                }
                if (maxI != -1) {
                    var tempD = curI - maxI;
                    minD = Math.min(minD, tempD);
                }
                maxI = curI;
            }
            curI += 1;
            p1 = p1.next;
        }
        if (minI == maxI) {
            return res;
        }
        res[0] = minD;
        res[1] = maxI - minI;
        return res;
    }

    private boolean isCritical(ListNode p1, ListNode p2) {
        if (p1.val < p1.next.val && p2.val < p1.next.val) {
            return true;
        }
        if (p1.val > p1.next.val && p2.val > p1.next.val) {
            return true;
        }
        return false;
    }
}
