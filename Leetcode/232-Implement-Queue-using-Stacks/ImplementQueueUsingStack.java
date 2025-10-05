import java.util.Stack;

public class ImplementQueueUsingStack {
    
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        out.pop();
    }

    // Get the front element.
    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.empty() && out.empty();
    }
}