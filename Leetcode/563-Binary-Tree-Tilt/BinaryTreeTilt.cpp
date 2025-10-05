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
    int findTilt(TreeNode* root) {
        postOrder(root);
        return tilt;
    }
private:
    int tilt = 0;

    int postOrder(TreeNode* node) {
        if (node == NULL) {
            return 0;
        }
        int left = postOrder(node->left);
        int right = postOrder(node->right);
        tilt += abs(left - right);
        return left + right + node->val;
    }
};
