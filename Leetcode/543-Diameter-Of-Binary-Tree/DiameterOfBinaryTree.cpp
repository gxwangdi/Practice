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
private:
    int helper(TreeNode* root, int & dia) {
        if (root == NULL)
            return (0);

        int l = helper(root->left, dia);
        int r = helper(root->right, dia);

        dia = max(dia, l + r);

        return (1 + max(l, r));

    }

public:
    int diameterOfBinaryTree(TreeNode* root) {
        int dia = 0;
        (void) helper(root, dia);
        return (dia);
    }
};
