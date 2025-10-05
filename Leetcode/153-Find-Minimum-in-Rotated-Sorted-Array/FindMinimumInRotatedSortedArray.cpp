class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size()-1;
        int target = nums[right];
        while (left + 1 < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] <= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] <= target) {
            return nums[left];
        }
        return nums[right];
    }
};
