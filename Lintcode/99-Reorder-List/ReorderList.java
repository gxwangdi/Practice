
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class ReorderList {
	/**
     * @param head: The head of linked list.
     * @return: void
     */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}

		ListNode head2 = p1.next;
		p1.next = null;

		p2 = head2.next;
		head2.next = null;
		while (p2 != null) {
			p1 = p2.next;
			p2.next = head2;
			head2 = p2;
			p2 = p1;
		}
		p1 = head;
		p2 = head2;
		while (p1 != null) {
			ListNode temp = p1.next;
			p1 = p1.next = p2;
			p2 = temp;
		}
	}// end of reorderList
    
    /*
    public void reorderList(ListNode head) {  
        
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        if (secondHead!=null) {
            ListNode p1 = secondHead;
            ListNode p2 = p1.next;
            while (p2!=null) {
                ListNode temp = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = temp;
            }
            secondHead = p1;
        }
        ListNode cur = head;
        ListNode firstHead = head.next;
        int count =1;
        while (firstHead!=null && secondHead!=null) {
            if (count%2 == 1) {
                cur.next = secondHead;
                secondHead = secondHead.next;
            } else {
                cur.next = firstHead;
                firstHead = firstHead.next;
            }
            count++;
            cur = cur.next;
        }
        if (firstHead!=null) {
            cur.next = firstHead;
        } else {
            cur.next = secondHead;
        }
    }
    
    // Use of these helpers will cause outOfMemory, test cases set a strict limit on memory consumption.  
    private ListNode mergeInterleaving(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int count = 0;
        while (n1!=null && n2!=null) {
            if (count%2 == 0) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
            count++;
        }
        if (n1!=null) {
            cur.next = n1;
        } else {
            cur.next = n2;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2!=null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    */
}
