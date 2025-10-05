class Solution {
public:
    int findMin(vector<int>& nums) {
        int res = nums[0];
        for (int i=1; i<nums.size(); i++) {
            res = min(res, nums[i]);
        }
        return res;
    }
};
