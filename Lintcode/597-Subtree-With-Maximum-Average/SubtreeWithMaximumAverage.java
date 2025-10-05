
public class SubtreeWithMaximumAverage {
	/**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Result[] max = new Result[1];
        Result res = getSubtreeSum(root, max);
        return max[0].node;
    }
    
    // node is not null.
    private Result getSubtreeSum(final TreeNode node, final Result[] max) {
        Result res = new Result(node, 1, node.val);
        if (node.left != null) {
            Result left = getSubtreeSum(node.left, max);
            res.numOfNodes += left.numOfNodes;
            res.totalSum += left.totalSum;
        }
        if (node.right != null) {
            Result right = getSubtreeSum(node.right, max);
            res.numOfNodes += right.numOfNodes;
            res.totalSum += right.totalSum;
        }
        if (max[0] == null) {
            max[0] = res;
        }
        if ( (((double)max[0].totalSum)/max[0].numOfNodes) 
        < (((double)res.totalSum)/res.numOfNodes) ) {
            max[0] = res;
        }
        return res;
    }
    
    private static class Result {
        public int numOfNodes;
        public long totalSum;
        public TreeNode node;
        public Result(TreeNode n, int num, long total) {
            node = n;
            numOfNodes = num;
            totalSum = total;
        }
    }
}
