
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
class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> isChild = new HashSet<>();
        for(int[] node : descriptions){
            int parant = node[0];
            int child = node[1];
            boolean isLeft = node[2] == 1;

            TreeNode c = map.getOrDefault(child, new TreeNode(child));
            map.put(child, c);
            isChild.add(child);
            TreeNode p = map.getOrDefault(parant, new TreeNode(parant));
            if(isLeft){
                p.left = c;
            }else{
                p.right = c;
            }
            map.put(parant, p);
        }
        for(int key : map.keySet()){
            if(!isChild.contains(key)){
                return map.get(key);
            }
        }
        return null;
    }
}
