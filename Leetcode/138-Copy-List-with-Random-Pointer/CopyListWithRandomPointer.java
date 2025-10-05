class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};


public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyPeer(head);
        copyRandom(head);
        RandomListNode node = split(head);
        return node;
    }
    
    private RandomListNode split(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        RandomListNode node = head;
        while (node!=null) {
            cur.next = node.next;
            node.next = node.next.next;
            cur = cur.next;
            node = node.next;
        }
        return dummy.next;
    }
    
    private void copyRandom(RandomListNode node) {
        RandomListNode head = node;        
        while (head!=null) {
            if (head.random!= null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private void copyPeer(RandomListNode listNode) {
        RandomListNode head = listNode;
        while (head != null) {
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = head.next.next;
        }
    } 
}




