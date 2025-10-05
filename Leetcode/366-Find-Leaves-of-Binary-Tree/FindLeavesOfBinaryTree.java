import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();    
        buildMappings(map, root);
        
        int cur = 1;
        while (map.containsKey(cur)) {
            res.add(map.get(cur));
            cur++;
        }
        return res;
    }// end of findLeaves   
    
    // node can never be null.
    private int buildMappings(Map<Integer, List<Integer>> map, TreeNode node) {
        int level = 1;
        if (node.left == null && node.right == null) {
            addToMap(map, node, level);
            return level;
        }
        if (node.left!=null) {
            int left = buildMappings(map, node.left);
            level = Math.max(level, left);
        }
        if (node.right!=null) {
            int right = buildMappings(map, node.right);
            level = Math.max(level, right);
        }
        level++;
        addToMap(map, node, level);
        return level;
    }
    
    private void addToMap(Map<Integer, List<Integer>> map, TreeNode node, int level) {
        if (!map.containsKey(level)) {
            List<Integer> list = new ArrayList<>();
            map.put(level, list);
        }
        map.get(level).add(node.val);
    }
}





