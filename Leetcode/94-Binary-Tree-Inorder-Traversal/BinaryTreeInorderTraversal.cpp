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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        TreeNode* cur = root;
        TreeNode* prev = NULL;
        while (cur!=NULL) {
            if (cur->left == NULL) {
                res.push_back(cur->val);
                cur = cur->right;
                continue;
            }
            prev = cur->left;
            while (prev->right!=NULL && prev->right!=cur) {
                prev = prev->right;
            }
            if (prev->right == NULL) {
                prev->right = cur;
                cur = cur->left;
            } else {
                prev->right = NULL;
                res.push_back(cur->val);
                cur = cur->right;
            }
        }
        return res;
    }
};
