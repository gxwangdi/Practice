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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.size() == 0) {
            return NULL;
        }
        return getBalanceBST(nums, 0, nums.size()-1);
    }

private:
    TreeNode* getBalanceBST(vector<int>& nums, int start, int end) {
        if (start > end) {
            return NULL;
        }
        int mid = start+(end-start)/2;
        TreeNode* root = new TreeNode(nums[mid]);
        if (start == end) {
            return root;
        }
        root->left = getBalanceBST(nums, start, mid-1);
        root->right= getBalanceBST(nums, mid+1, end);
        return root;
    }
};
