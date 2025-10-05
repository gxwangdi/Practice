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
    bool isBalanced(TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        if (getHeight(root)==-1) {
            return false;
        }
        return true;
    }
    
private:
    int getHeight(TreeNode* node) {
        if (node == NULL) {
            return 0;
        }
        int left = getHeight(node->left);
        int right = getHeight(node->right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (abs(left-right)>1) {
            return -1;
        }
        return max(left, right) + 1;
    }
};


