
class MyCircularDeque {

    int v[];
    int left=0;
    int right=-1;
    public MyCircularDeque(int k) {
        v=new int[k];
    }

    private int getRealIndex(int i){
        if(i<0){
            return i%v.length+v.length;
        }else{
            return i%v.length;
        }
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        v[getRealIndex(++right)]=value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        v[getRealIndex(--left)]=value;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        right--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        left++;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return v[getRealIndex(right)];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return v[getRealIndex(left)];
    }

    public boolean isEmpty() {
        return left>right;
    }

    public boolean isFull() {
        return right-left==v.length-1;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
 
