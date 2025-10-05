class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if (nums.empty()) {
            return 0;
        }
        int start = 0;
        int end = nums.size()-1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid -1;
            } else {
                start = mid +1;
            }
        }
        // start == end
        if (nums[start] < target) {
            return start+1;
        }
        return start;
    }
};
