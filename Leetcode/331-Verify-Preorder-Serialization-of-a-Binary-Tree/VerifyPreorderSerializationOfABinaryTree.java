import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        String[] nodes = preorder.split(",");
        String s = nodes[0];
        TreeNode node = null;
        if (!"#".equals(s)) {
            node = new TreeNode(Integer.valueOf(s));
        }
        Stack<TreeNode> stack = new Stack<>();     
        int cur =1;
        while (cur<nodes.length) {
            if (node == null) {
                // pop and init right child
                if (stack.empty()) {
                    return false;
                }
                node = stack.pop();
                s = nodes[cur++];
                TreeNode tn = null;
                if (!"#".equals(s)) {
                    tn = new TreeNode(Integer.valueOf(s));
                }
                node.right = tn;
                node = node.right;
            } else {
                // init left child and push node into stack.
                s = nodes[cur++];
                TreeNode tn = null;
                if (!"#".equals(s)) {
                    tn = new TreeNode(Integer.valueOf(s));
                }
                node.left = tn;
                stack.push(node);
                node = node.left;
            }
        }
        return (node == null) && stack.empty();
    }
    
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int v) {
            val = v;
        }
    }// end of TreeNode 
}



