#include <limits>
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
    int minDepth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        return getMin(root);
    }
private:
    int getMin(TreeNode* node) {
        if (node == NULL) {
            return std::numeric_limits<int>::max();
        }
        if (node->left == NULL && node->right == NULL) {
            return 1;
        }
        return min(getMin(node->left), getMin(node->right)) + 1;
    }
};


