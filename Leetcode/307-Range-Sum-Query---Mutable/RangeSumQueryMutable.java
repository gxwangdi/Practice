public class RangeSumQueryMutable {
    
    // Binary Index Tree Approach
    private int[] nums;
    private int[] BIT;
    private int n;
    
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        
        n = nums.length;
        BIT = new int[n+1];
        for (int i=0; i<n; i++) {
            init(i, nums[i]);
        }
    }
    
    private void init(int index, int val) {
        index++;
        while (index <= n) {
            BIT[index] += val;
            index += (index & -index);
        }
    }
    
    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }
    
    private int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
    
    /*
    // Segment Tree Approach
    private static class SegmentTreeNode {
        public int start;
        public int end;
        public int sum;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        public SegmentTreeNode(int s, int e, int sum) {
            left = right = null;
            start = s;
            end = e;
            this.sum = sum;
        }
    }// end of class SegmentTreeNode  
    
    private SegmentTreeNode root;
    
    public NumArray(int[] nums) {
        root = build(nums);
    }
    
    private SegmentTreeNode build(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        SegmentTreeNode stn = new SegmentTreeNode(left, right, 0);
        if (left == right) {
            stn.sum = nums[left];
            return stn;
        }
        int mid = (left + right)/2;
        stn.left = buildTree(nums, left, mid);
        stn.right = buildTree(nums, mid+1, right);
        if (stn.left != null) {
            stn.sum += stn.left.sum;
        }
        if (stn.right != null) {
            stn.sum += stn.right.sum;
        }
        return stn;
    }
    
    void update(int i, int val) {
        updateTree(root, i, val);
    }
    
    private void updateTree(SegmentTreeNode node, int pos, int val) {
        if (node.start == node.end) {
            node.sum = val;
            return;
        }
        int mid = (node.start + node.end)/2;
        if (pos <= mid) {
            updateTree(node.left, pos, val);
        } else {
            updateTree(node.right, pos, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode stn, int left, int right) {
        if (stn.start == left && stn.end == right) {
            return stn.sum;
        }
        int mid = (stn.start + stn.end)/2;
        if (right <= mid) {
            return sumRange(stn.left, left, right);
        } else if (left > mid) {
            return sumRange(stn.right, left, right);
        } else {
            return sumRange(stn.left, left, mid) + sumRange(stn.right, mid+1, right);
        }
    }
    */
    
    
    
    
    
    /*
    // Prefix Sum approach. TLE. 
    private int[] src;
    private long[] sum;      
    
    public NumArray(int[] nums) {
        src = nums;
        if (nums == null || nums.length == 0) {
            return;
        }
        sum = new long[nums.length];    
        sum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }

    void update(int i, int val) {
        int diff = val - src[i];
        src[i] = val;
        for (int index = i; index<src.length; index++) {
            sum[index] += diff;
        }
    }

    public int sumRange(int i, int j) {
        long res = sum[j];
        if (i > 0) {
            res -= sum[i-1];
        }
        return (int)res;
    }
    */
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);



