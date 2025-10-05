
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class InsertIntoACyclicSortedList {
	/**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        if (node == null) {
            ListNode n = new ListNode(x);
            n.next = n;
            return n;
        }
        ListNode start = node;
        while (!isTheRightNode(node, x)) {
            if (node.next == start) {
                break;
            }
            node = node.next;
        }
        return insertNewNode(node, x);
    }
    private boolean isTheRightNode(ListNode node, int x) {
        if (node.val == x) {
            return true;
        }
        if (node.val < node.next.val) {
            if (node.val < x && x < node.next.val) {
                return true;
            }
        } else if (node.next.val != node.val){
            if (x < node.next.val || x > node.val) {
                return true;
            }
        }
        return false;
    }
    /*
    @param node next of which is where the insertion happens
    @param x the value
    @return the newly inserted node
    */
    private ListNode insertNewNode(ListNode node, int x) {
        ListNode n = new ListNode(x);
        n.next = node.next;
        node.next = n;
        return n;
    }
}
