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
var isSymmetric = function(root) {
    if (!root) {
        return true
    }
    return isSymmetricForTwo(root.left, root.right)
};

var isSymmetricForTwo = function(left, right) {
    if (!left && !right) {
        return true
    }
    if (!left || !right) {
        return false
    }
    if (left.val != right.val) {
        return false
    }
    return isSymmetricForTwo(left.left, right.right) && isSymmetricForTwo(right.left, left.right)
};
