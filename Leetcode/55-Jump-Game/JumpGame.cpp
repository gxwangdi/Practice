class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size() == 0) {
            return false;
        }
        // If not init, will have runtime error
        bool dp[nums.size()] = {false};
        dp[0] = true;
        int cur = 0;
        for (int i=0; i<nums.size(); i++) {
            if (!dp[i]) {
                return false;
            }
            int far = i+nums[i];
            if (far >= nums.size()-1) {
                return true;
            }
            if (far < cur) {
                continue;
            }
            while (cur <= far) {
                dp[cur] = true;
                cur++;
            }
        }
        return dp[nums.size()-1];
    }
};
