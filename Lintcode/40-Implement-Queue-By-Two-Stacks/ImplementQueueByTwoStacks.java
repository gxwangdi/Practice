import java.util.Stack;


public class ImplementQueueByTwoStacks {

	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByTwoStacks() {
       // do initialization if necessary
       stack1 = new Stack<>();
       stack2 = new Stack<>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}
