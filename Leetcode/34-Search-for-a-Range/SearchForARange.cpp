class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res;
        if (nums.size() == 0) {
            res.push_back(-1);
            res.push_back(-1);
            return res;
        }
        int lower = binarySearch(nums, target, true);
        res.push_back(lower);
        if (lower == -1) {
            res.push_back(-1);
            return res;
        }
        res.push_back(binarySearch(nums, target, false));
        return res;
    }
private:
    int binarySearch(vector<int>& nums, int target, bool isLowerBound) {
        int left = 0;
        int right = nums.size()-1;
        while (left+1 < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target) {
                if (isLowerBound) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (nums[mid] < target) {
                left = mid;
                continue;
            }
            if (nums[mid] > target) {
                right = mid;
            }
        }
        int res = -1;
        if (isLowerBound) {
            if (nums[left] == target) {
                res = left;
            } else if (nums[right] == target) {
                res = right;
            }
        } else {
            if (nums[right] == target) {
                res = right;
            } else if (nums[left] == target) {
                res = left;
            }
        }
        return res;
    }
};
