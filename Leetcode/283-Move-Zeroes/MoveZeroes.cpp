class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        if (nums.size()<2) {
            return;
        }
        int slow=0;
        int fast=0;
        while (fast < nums.size()) {
            if (nums[fast]==0) {
                fast++;
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
            fast++;
        }
        while (slow < nums.size()) {
            nums[slow] = 0;
            slow++;
        }
    }
};
