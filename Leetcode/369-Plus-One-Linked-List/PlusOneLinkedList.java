import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        Stack<ListNode> stack = new Stack<>();
        while (cur.next!=null) {
            stack.push(cur);
            cur = cur.next;
        }
        do {
            if (cur.val < 9) {
                cur.val++;
                break;
            } else {
                cur.val = 0;
                cur = stack.pop();
            }
        } while (!stack.empty());
        if (stack.empty()) {
            cur.val++;
        }
        if (dummy.val >0) {
            return dummy;
        }
        return dummy.next;
    }
}



