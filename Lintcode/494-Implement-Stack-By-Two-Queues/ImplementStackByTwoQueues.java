import java.util.LinkedList;
import java.util.Queue;


public class ImplementStackByTwoQueues {
private final int INVALID_VALUE = Integer.MIN_VALUE;
    
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top = INVALID_VALUE;
    
    // Push a new item into the stack
    public void push(int x) {
        if (top != INVALID_VALUE) {
            if (q1.isEmpty()) {
                q2.offer(top);
            } else {
                q1.offer(top);
            }
        }
        top = x;
    }

    // Pop the top of the stack
    public void pop() {
        Queue<Integer> content;
        Queue<Integer> reverse;
        if (q1.isEmpty()) {
            content = q2;
            reverse = q1;
        } else {
            content = q1;
            reverse = q2;
        }
        Integer temp = null;
        while (!content.isEmpty()) {
            if (temp != null) {
                reverse.offer(temp);
            }
            temp = content.poll();
        }
        if (temp == null) {
            top = INVALID_VALUE;
        } else {
            top = temp;
        }
    }

    // Return the top of the stack
    public int top() {
        return top;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty() && top == INVALID_VALUE;
    }
}
