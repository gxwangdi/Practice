class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() == 0) {
            return -1;
        }
        if (nums.size() == 1) {
            return 0;
        }
        int dp[nums.size()] = {INT_MAX};
        dp[0]=0;
        int cur = 1;
        for (int i=0; i<nums.size(); i++) {
            int far = i + nums[i];
            int value = dp[i] + 1;
            if (far >= nums.size()-1) {
                return value;
            }
            if (far < cur) {
                continue;
            }
            while (cur <= far) {
                dp[cur] = value;
                cur++;
            }
        }
        return dp[nums.size()-1];
    }
};
