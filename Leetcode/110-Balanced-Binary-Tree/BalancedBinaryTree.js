/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var getHeight = function(node) {
    if (!node) {
        return 0
    }
    var left = getHeight(node.left)
    var right = getHeight(node.right)
    if (left == -1 || right == -1) {
        return -1
    }
    if (Math.abs(left-right)>1) {
        return -1
    }
    return Math.max(left, right)+1
};

var isBalanced = function(root) {
    if (!root) {
        return true
    }
    if (getHeight(root) == -1) {
        return false
    }
    return true
};

