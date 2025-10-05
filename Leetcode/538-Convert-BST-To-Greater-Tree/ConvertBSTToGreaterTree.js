/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var convertBST = function(root) {
    if (!root) {
        return root
    }
    var convert = function(node, sum) {
        if (!node) {
            return sum
        }
        node.val += convert(node.right, sum)
        return convert(node.left, node.val)
    };
    convert(root, 0)
    return root
};
