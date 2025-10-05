class MinStack {
private:
    stack<int> elements;
    stack<int> min;
public:
    /** initialize your data structure here. */
    MinStack() {

    }

    void push(int x) {
        if (min.empty() || x<=min.top()) {
            min.push(x);
        }
        elements.push(x);
    }

    void pop() {
        int top = elements.top();
        elements.pop();
        if ( top == min.top()) {
            min.pop();
        }
    }

    int top() {
        return elements.top();
    }

    int getMin() {
        return min.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
 
