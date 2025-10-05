public class ConvertBSTToGreaterTree {
  public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root, 0);
        return root;
    }

    private int convertBST(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        node.val += convertBST(node.right, sum);
        return convertBST(node.left, node.val);
    }
}
