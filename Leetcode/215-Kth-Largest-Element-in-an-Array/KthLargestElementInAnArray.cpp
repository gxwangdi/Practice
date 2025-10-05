class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        if (nums.size() == 0 || k<=0) {
            return 0;
        }
        // In Ascending order, kth largest is nums.length-k+1
        return helper(nums, 0, nums.size()-1, nums.size()-k+1);
    }
private:
    int helper(vector<int>& nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pos = partition(nums, left, right);
        if (pos+1 == k) {
            return nums[pos];
        } else if (pos+1 < k) {
            return helper(nums, pos+1, right, k);
        } else {
            return helper(nums, left, pos-1, k);
        }
    }// end of helper

    int partition(vector<int>& nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right]>=pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left]<pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
};
