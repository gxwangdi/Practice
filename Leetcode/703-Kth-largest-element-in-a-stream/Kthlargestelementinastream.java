

class Kthlargestelementinastream {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq  = new PriorityQueue<>(k);
        for(int n: nums){
            addNew(n);
        }
    }

    public int add(int val) {
        addNew(val);
        return pq.peek();
    }

    private void addNew(int n){
        if(pq.size() < k){
            pq.add(n);
            return;
        }
        if(n > pq.peek()) {
            pq.poll();
            pq.add(n);
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
