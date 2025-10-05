/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var findTilt = function(root) {
    var tilt = 0

    var postOrder = function(node) {
        if (!node) {
            return 0
        }
        var left = postOrder(node.left)
        var right = postOrder(node.right)
        tilt += Math.abs(left-right)
        return left+right+node.val
    }
    postOrder(root)
    return tilt
};
