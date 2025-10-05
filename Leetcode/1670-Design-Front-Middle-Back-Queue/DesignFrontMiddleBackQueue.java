

class FrontMiddleBackQueue {
//     private static class DLN {
//         int val;
//         DLN next, prev;
//     }

//     private boolean isEven;
//     DLN head;
//     DLN tail;
//     DLN front;
//     DLN back;
//     DLN middle;

//     public FrontMiddleBackQueue() {
//         isEven = true;
//         head = new DLN();
//         tail = new DLN();
//         head.next = tail;
//         tail.prev = head;
//     }
    private final List<Integer> q = new ArrayList<>();

    public void pushFront(int val) {
    q.add(0,val);
}

public void pushMiddle(int val) {
    q.add(q.size()/2,val);
}

public void pushBack(int val) {
    q.add(val);
}

public int popFront() {
    if(q.isEmpty())
        return -1;
    else
        return q.remove(0);

}

public int popMiddle() {
if(q.isEmpty())
        return -1;
    else
        return q.remove((q.size()-1)/2);
}

public int popBack() {
    if(q.isEmpty())
        return -1;
    else
        return q.remove(q.size()-1);
}
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
