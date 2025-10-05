class DesignLinkedList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {
            val = v;
        }
        ListNode(int v, ListNode n) {
            val = v;
            next = n;
        }
    }

    private final ListNode dummy;
    private ListNode tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummy = new ListNode(0);
        tail = dummy;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        ListNode cur = dummy.next;
        while (cur!= null && index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur == null) {
            return -1;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode temp = createNode(val);
        temp.next = dummy.next;
        dummy.next = temp;
        if (tail == dummy) {
            tail = temp;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = createNode(val);
        tail.next = temp;
        tail = temp;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        ListNode node = createNode(val);
        ListNode cur = dummy;
        while (cur.next!= null && index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur.next == null) {
            if (index == 0) {
                cur.next = node;
                tail = node;
            } else {
                return;
            }
        } else {
            node.next = cur.next;
            cur.next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode prev = getAt(index);
        if (prev == null) {
            return;
        }
        prev.next = prev.next.next;
        if (prev.next == null) {
            tail = prev;
        }
    }

    private ListNode createNode(int val) {
        ListNode temp = new ListNode(val);
        return temp;
    }

    /**
     * return the prev of the index node, null if it does not exist.
    */
    private ListNode getAt(int index) {
        if (index < 0) {
            return null;
        }
        ListNode cur = dummy;
        while (cur.next!= null && index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur.next == null) {
            return null;
        }
        return cur;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
