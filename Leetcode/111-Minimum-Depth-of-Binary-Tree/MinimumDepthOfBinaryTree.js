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
var minDepth = function(root) {
    if (!root) {
        return 0
    }
    return getMin(root);
};

var getMin = function(node) {
    if (!node) {
        return Infinity
    }
    if (!node.left && !node.right) {
        return 1
    }
    return Math.min(getMin(node.left), getMin(node.right)) +1
};


