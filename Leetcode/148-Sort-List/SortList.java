/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    
    private static class MergeHelper {
        public ListNode newHead;
        public ListNode newTail;
    }

    public ListNode sortList(ListNode head) {
    if ( head == null || head.next == null) {
        return head;
    }
    
    ListNode dummyHeadOne = new ListNode(0);
    ListNode dummyHeadTwo = new ListNode(0);
    ListNode dummySortedHead = new ListNode(0);
    ListNode dummySortedLast = dummySortedHead;
    ListNode unvisitedNode = head;
    MergeHelper mergeRst = new MergeHelper();
    
    int listLength = 0;
    int level = 0;
    while ( unvisitedNode != null && unvisitedNode.next != null ) {
        unvisitedNode = addNode ( dummyHeadOne, unvisitedNode, 1<<level);
        unvisitedNode = addNode ( dummyHeadTwo, unvisitedNode, 1<<level);
        merge ( dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
        dummySortedLast.next = mergeRst.newHead;
        dummySortedLast = mergeRst.newTail;
        listLength += 2;
    }
    if (unvisitedNode != null) {
        dummySortedLast.next = unvisitedNode;
        listLength ++;
    }
    level ++;
    
    while ( listLength > 1 << level) {
        dummySortedLast = dummySortedHead;
        unvisitedNode = dummySortedHead.next;
        while (unvisitedNode != null) {
            unvisitedNode = addNode ( dummyHeadOne, unvisitedNode, 1<<level);
            unvisitedNode = addNode ( dummyHeadTwo, unvisitedNode, 1<<level);
            merge ( dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
            dummySortedLast.next = mergeRst.newHead;
            dummySortedLast = mergeRst.newTail;
        }
        level ++;
    }
    
    return dummySortedHead.next;
    }
    
    /* merge listOne and listTwo. 
Save the sorted list head into rst.newHead
Save the last node of the sorted list into rst.newTail
*/
private void merge (ListNode listOne, ListNode listTwo, MergeHelper rst) {
    ListNode dummyHead = new ListNode (0);
    ListNode lastNode = dummyHead;
    while (listOne != null && listTwo != null) {
        if ( listOne.val < listTwo.val ) {
            lastNode.next = listOne;
            listOne = listOne.next;
        } else {
            lastNode.next = listTwo;
            listTwo = listTwo.next;
        }
        lastNode = lastNode.next;
    }
    
    while (listOne != null) {
        lastNode.next = listOne;
        listOne = listOne.next;
        lastNode = lastNode.next;
    }
    while ( listTwo != null ) {
        lastNode.next = listTwo;
        listTwo = listTwo.next;
        lastNode = lastNode.next;
    }
    rst.newHead = dummyHead.next;
    rst.newTail = lastNode;
}

/*
 add at max #"count" nodes into "head" from "source"
 return the new position of source after adding.
*/
private ListNode addNode ( ListNode head, ListNode source, int count ) {
    while (count > 0 && source != null) {
        head.next = source;
        head = head.next;
        source = source.next;
        count --;
    }
    head.next = null;
    return source;
}
    
    /*
    // quick sort.  TLE
    // Still it has recursion for left = sortList(ListNode); and right = sortList(ListNode);
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = head;
        ListNode midTail = mid;
        
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;
        
        while (head!=null) {
            if (head.val < mid.val) {
                if (leftHead == null) {
                    leftHead = leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
            } else if (head.val > mid.val) {
                if (rightHead == null) {
                    rightHead = rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            } else {
                midTail.next = head;
                midTail = midTail.next;
            }
        }
        leftTail.next = null;
        rightTail.next = null;
        midTail.next = null;
        
        ListNode left = sortList(leftHead);
        ListNode right = sortList(rightHead);
        return concat(left, mid, right);
    }
    
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        tail.next = left; tail = getTail(tail);
        tail.next = middle; tail = getTail(tail);
        tail.next = right; tail = getTail(tail);
        return dummy.next;
    }
    
    private ListNode getTail(ListNode head) {
        if (head == null) {
           return null;
        } 
       
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    */
    
    
    
    /* // Merge sort, where there is a recursion, there is a stackOverFlow error. 
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode right = sortList(temp);
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1!=null && head2!=null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1!=null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }
    */
}

