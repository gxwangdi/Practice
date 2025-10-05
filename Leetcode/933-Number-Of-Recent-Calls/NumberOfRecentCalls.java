
class RecentCounter {

    Queue<Integer> que;

    public RecentCounter() {
    	que = new ArrayDeque<>();
    }

    public int ping(int t) {
        int rem = t - 3000;
    	que.add(t);
    	while(que.peek() < rem)
    		que.remove();
    	return que.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
