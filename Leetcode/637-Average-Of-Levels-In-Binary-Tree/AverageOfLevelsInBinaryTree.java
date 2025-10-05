

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> q=new ArrayDeque<>();
        List<Double> li=new ArrayList<>();
        if(root==null) return li;

        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int n=size;
            double avg=0.0;
            while(size-->0){
            TreeNode temp=q.remove();
                avg+=temp.val;

                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            li.add(avg/n);
        }

        return li;
    }
}
