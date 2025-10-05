import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeVerticalOrderTraversal {
    
    // BFS 
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int[] mm = new int[2];
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (map.containsKey(p.degree)) {
                map.get(p.degree).add(p.node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p.node.val);
                map.put(p.degree, list);
            }
            
            if (p.node.left != null) {
                q.offer(new Pair(p.node.left, p.degree-1));
                mm[0] = Math.min(mm[0], p.degree-1);
            }
            if (p.node.right != null) {
                q.offer(new Pair(p.node.right, p.degree+1));
                mm[1] = Math.max(mm[1], p.degree+1);
            }
        }
        for (int i=mm[0]; i<=mm[1]; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    
    private static class Pair {
        public TreeNode node;
        public int degree;
        public Pair(TreeNode tn, int d) {
            node = tn;
            degree = d;
        }
    }
    
    /*
    // DFS.  The answer is correct, but the test case requires BFS sequence. 
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] minmax = new int[2]; // minmax[0] as min, minmax[1] as max.
        getOrderMapping(map, root, minmax, 0);
        
        for (int i=minmax[0]; i<=minmax[1]; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    
    private void getOrderMapping(Map<Integer, List<Integer>> map, TreeNode node, int[] mm, int degree)
    {
        if (node == null) {
            return;
        }
        mm[0] = Math.min(mm[0], degree);
        mm[1] = Math.max(mm[1], degree);
        
        if (map.containsKey(degree)) {
            map.get(degree).add(node.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(degree, list);
        }
        getOrderMapping(map, node.left, mm, degree-1);
        getOrderMapping(map, node.right, mm, degree+1);
    }
    */
}






