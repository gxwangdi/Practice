class BrowserHistory {

    private List<String> q = new ArrayList<>();
    private int cur;

    public BrowserHistory(String homepage) {
        cur = 0;
        q.add(homepage);
    }

    public void visit(String url) {
        // q.setSize(cur+1);
        q = q.subList(0, cur+1);
        q.add(url);
        cur += 1;
    }

    public String back(int steps) {
        var d = Math.min(cur, steps);
        cur -= d;
        return q.get(cur);
    }

    public String forward(int steps) {
        var d = Math.min(q.size()-1-cur, steps);
        cur += d;
        return q.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
