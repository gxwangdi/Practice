class Solution {
public:
    void sortColors(vector<int>& nums) {
        if (nums.size()<2) {
            return;
        }
        int cur = 0;
        int left = 0;
        int right = nums.size()-1;
        while (left<nums.size()) {
            while (left<nums.size() && nums[left]==cur) {
                left++;
            }
            while (right>=0 && nums[right]!=cur) {
                right--;
            }
            if (left<right) {
                swap(nums, left, right);
                left++;
                right--;
            } else {
                right = nums.size()-1;
                cur++;
            }
        }
    }

private:
    void swap(vector<int>& nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};
