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
    TreeNode* searchBST(TreeNode* root, int val) {
        TreeNode* cur = root;
        while (cur!=NULL) {
            if (cur->val == val) {
                break;
            }
            if (cur->val > val) {
                cur = cur->left;
                continue;
            }
            cur = cur->right;
        }
        return cur;
    }
};
