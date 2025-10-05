

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
class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        var stack = new Stack<int[]>();
        var list = new ArrayList<Integer>();
        var pos = 0;
        var cur = head;
        var size = 0;
        while (cur != null) {
            size +=1;
            cur = cur.next;
        }
        var res = new int[size];
        cur = head;
        while (cur != null) {
            var curVal = cur.val;
            while (!stack.isEmpty() && curVal > stack.peek()[1]) {
                var item = stack.pop();
                // list.add(item[0], item[1]);
                res[item[0]] = curVal;
            }
            stack.push(new int[]{pos, curVal});
            cur = cur.next;
            pos++;
        }
        // while (!stack.isEmpty()) {
        //     var item = stack.pop();
        //     list.add(item[0], 0);
        //     res[item[0]] = 0;
        // }

        // return list.stream().mapToInt(Integer::intValue)
        //                     .toArray();
        return res;
    }
}
