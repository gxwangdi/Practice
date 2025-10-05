/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    var res = []
    var cur = root
    var prev
    while (cur) {
        if (!cur.left) {
            res.push(cur.val)
            cur = cur.right
            continue
        }
        prev = cur.left
        while (prev.right && prev.right!=cur) {
            prev = prev.right
        }
        if (!prev.right) {
            prev.right = cur
            cur = cur.left
        } else {
            res.push(cur.val)
            prev.right = null
            cur = cur.right
        }
    }
    return res
};
