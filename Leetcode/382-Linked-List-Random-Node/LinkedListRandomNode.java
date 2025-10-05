import java.util.ArrayList;
import java.util.List;

public class LinkedListRandomNode {

    // java.util.Random rand = new java.util.Random();
    // int len = 0;
    // ListNode head;
     
    // public Solution(ListNode head) {
    //     this.head = head;
    //     ListNode p = head;
    //     while(p != null){ // How it counts len! 
    //         p = p.next;
    //         len++;
    //     }
    // }
    
    // public int getRandom() {
    //     ListNode p = head;
    //     int k = rand.nextInt(len);
    //     // int i = 0;
    //     while( k>0 ){
    //         p = p.next;
    //         k--;
    //     }
    //     return p.val;
    // }
    
    private java.util.Random rand;
    private List<Integer> list;
    
    public LinkedListRandomNode(ListNode head) {
        rand = new java.util.Random();
        ListNode cur = head;
        list = new ArrayList<>();
        while (cur!=null) {
            list.add(cur.val);
            cur = cur.next;
        }
    }
    
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
    
    // int count;
    // private ListNode head;
    // private ListNode dummy;
    // java.util.Random rand;
    
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    // public Solution(ListNode head) {
    //     rand = new java.util.Random();
    //     dummy = new ListNode(0);
    //     dummy.next = head;
    //     this.head = head;
    //     // count = 1;
    //     count = 0;
    //     // ListNode cur = dummy;
    //     ListNode cur = head;
    //     while (cur!=null) {
    //         cur = cur.next;
    //         count++;
    //     }
    // }
    
    /** Returns a random node's value. */
    // public int getRandom() {
    //     int steps = (int)(Math.random()*count); // map 0...1 to 0...count
    //     int k = rand.nextInt(count);
    //     ListNode cur = dummy.next;
    //     // while (steps > 0) {
    //     //     cur = cur.next;
    //     //     steps--;
    //     // }
    //     for (int i=0; i<k; i++) {
    //         cur = cur.next;
    //     }
    //     return cur.val;
    // }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
 
 
 
 
 