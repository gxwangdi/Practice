import java.util.Stack;


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class DoublyListNode {
	int val;
	DoublyListNode next, prev;

	DoublyListNode(int val) {
		this.val = val;
		this.next = this.prev = null;
	}
}
  
public class ConvertBinarySearchTreeToDoublyLinkedList {
	/**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
     // Iterative approach
	public DoublyListNode bstToDoublyList(TreeNode root) {
		DoublyListNode dummy = new DoublyListNode(0);
		DoublyListNode cur = dummy;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.empty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.empty()) {
				node = stack.pop();
				DoublyListNode temp = new DoublyListNode(node.val);
				temp.prev = cur;
				cur.next = temp;
				cur = cur.next;
				node = node.right;
			}
		}
		return dummy.next;
	}
     
     
    /* // Recursive approach.
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if (root == null) {
            return null;
        }
        DoublyListNode[] res = toDoublyList(root);
        return res[0];
    }
    
    private DoublyListNode[] toDoublyList(TreeNode node) {
        DoublyListNode[] res = new DoublyListNode[2];
        DoublyListNode root = new DoublyListNode(node.val);
        res[0] = root;
        res[1] = root;
        if (node.left == null && node.right == null) {
            return res;
        }
        if (node.left!=null) {
            DoublyListNode[] leftList = toDoublyList(node.left);
            res[0] = leftList[0];
            leftList[1].next = root;
            root.prev = leftList[1];
        } 
        if (node.right!=null) {
            DoublyListNode[] rightList = toDoublyList(node.right);
            res[1] = rightList[1];
            root.next = rightList[0];
            rightList[0].prev = root;
        }
        return res;
    }*/
}
