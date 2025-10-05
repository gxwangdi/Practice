import java.util.ArrayDeque;
import java.util.Deque;

class ImplementStackUsingQueues {
    
    private Integer topElement;
    
    private Deque<Integer> mQueue = new ArrayDeque<>();
    
    // Push element x onto stack.
    public void push(int x) {
        if (topElement != null) {
            mQueue.offer(topElement);
        }
        topElement = new Integer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (topElement == null) {
            topElement = loadTop();
        }
        topElement = loadTop();
    }

    // Get the top element.
    public int top() {
        if (topElement == null) {
            topElement = loadTop();
        }
        return topElement.intValue();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return topElement == null && mQueue.isEmpty();
    }
    
    // Returns the last in and removes it from the queue.   
    private Integer loadTop() {
        Deque<Integer> temp = new ArrayDeque<>();
        while (mQueue.size()>1) {
            temp.offer(mQueue.poll());
        }
        Integer top = mQueue.poll();
        mQueue = temp;
        return top;
    }
}