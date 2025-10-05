

class Designastackwithincrementoperation {
    int[] stack;
    int index;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        index=-1;
    }

    public void push(int x) {
       if (index+1<stack.length){
           index++;
           stack[index] = x;
        }
    }

    public int pop() {
        if(index == -1) return -1;
        return stack[index--];
    }

    public void increment(int k, int val) {
        if(index == -1) return;
        int count = Math.min(k, index+1);
        for(int i = 0;i<count;i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
