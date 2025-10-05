

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
class RemoveZeroSumConsecutiveNodesFromLinkedList {
    /*
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        var dummy = new ListNode();
        dummy.next = head;
        int preSum = 0;
        var cur = dummy;
        while (cur.next != null) {
            preSum += cur.next.val;
            if (preSum == 0) {
                var temp = cur.next;
                cur = temp.next;
                removeSeq(dummy, temp);
                map.clear();
                continue;
            }
            if (map.containsKey(preSum)) {
                var tempNode = map.get(preSum);
                map.remove(preSum);
                cur = cur.next;
                removeSeq(tempNode.next, cur);
                continue;
            }
            map.put(preSum, cur);
            cur = cur.next;
        }
        preSum += cur.val;
        if (map.containsKey(preSum)) {
            var tempNode = map.get(preSum);
            map.remove(preSum);
            tempNode.next.next = null;
        }
        return dummy.next;
    }

    private void removeSeq(ListNode head, ListNode tail) {
        head.next = tail.next;
        tail.next = null;
    }
    */
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return null;
        HashMap < Integer , ListNode> hm = new HashMap<>();
        //we make a hashmap so that further we can manipulate sum and nodes.
        ListNode dummy = new ListNode(0), curr = head;
        hm.put(0 , dummy);
        dummy.next = head;
        int sum = 0;

        while(curr != null ){
            sum += curr.val;
            if(hm.containsKey(sum)){
                int currSum = sum;
                ListNode toRemove = hm.get(sum).next;
                while(toRemove != curr){

                    currSum += toRemove.val;
                    hm.remove(currSum);
                    toRemove = toRemove.next;
                }
                hm.get(sum).next = curr.next;
            }else{
                hm.put(sum , curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
