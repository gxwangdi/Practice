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
var diameterOfBinaryTree = function(root) {
    var getDiameter = function(node) {
        var res = [0,0]
        if (!node) {
            return res
        }
        var left = getDiameter(node.left)
        var right = getDiameter(node.right)
        res[0] = Math.max(left[1]+right[1], Math.max(left[0], right[0]))
        res[1] = Math.max(left[1], right[1])+1
        return res
    };
    var res = getDiameter(root)
    return res[0]
};
