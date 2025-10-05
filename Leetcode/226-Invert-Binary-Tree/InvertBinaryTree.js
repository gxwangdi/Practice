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
var invertTree = function(root) {
    invertNode(root)
    return root
    
    function invertNode(node) {
        if (node != undefined) {
            var tmp = node.left
            node.left = node.right
            node.right = tmp
            invertNode(node.left)
            invertNode(node.right)
        }
    }
    
};

