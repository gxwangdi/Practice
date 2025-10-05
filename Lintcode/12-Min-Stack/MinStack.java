import java.util.Stack;


public class MinStack {
	
	private Stack<Integer> mContent;
    private Stack<Integer> mMeta;
    
    public MinStack() {
        // do initialize if necessary
        mContent = new Stack<>();
        mMeta = new Stack<>();
    }

    public void push(int number) {
        if (mMeta.empty() || number <= mMeta.peek()) {
            mMeta.push(number);
        }
        mContent.push(number);
    }

    public int pop() {
        int element = mContent.pop();
        if (element <= mMeta.peek()) {
            mMeta.pop();
        }
        return element;
    }

    public int min() {
        if (mMeta.empty()) {
            return Integer.MIN_VALUE;
        }
        return mMeta.peek();
    }
}
