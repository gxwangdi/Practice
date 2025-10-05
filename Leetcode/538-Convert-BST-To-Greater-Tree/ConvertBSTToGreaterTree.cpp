/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* convertBST(TreeNode* root) {
        if (root == NULL) {
            return root;
        }
        convertBST(root, 0);
        return root;
    }
private :
    int convertBST(TreeNode* node, int sum) {
        if (node == NULL) {
            return sum;
        }
        node->val += convertBST(node->right, sum);
        return convertBST(node->left, node->val);
    }
};
