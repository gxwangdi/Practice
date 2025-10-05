/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} val
 * @return {TreeNode}
 */
var insertIntoBST = function(root, val) {
    var node = new TreeNode(val)
    if (!root) {
        root = node
        return root
    }
    var cur = root
    while (true) {
        if (cur.val >val) {
            if (!cur.left) {
                cur.left = node
                break
            }
            cur = cur.left
            continue
        }
        if (!cur.right) {
            cur.right = node
            break
        }
        cur = cur.right
    }
    return root
};
