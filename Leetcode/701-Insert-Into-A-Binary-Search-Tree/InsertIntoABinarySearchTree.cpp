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
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        TreeNode* node = new TreeNode(val);
        if (root == NULL) {
            root = node;
            return root;
        }
        TreeNode* cur = root;
        while(true) {
            if (cur->val > val) {
                if (cur->left == NULL) {
                    cur->left = node;
                    break;
                }
                cur = cur->left;
                continue;
            }
            if (cur->right == NULL) {
                cur->right = node;
                break;
            }
            cur = cur->right;
        }
        return root;
    }
};
