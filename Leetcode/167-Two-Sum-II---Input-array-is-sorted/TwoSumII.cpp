class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> res;
        int left=0, right=numbers.size()-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res.push_back(left+1);
                res.push_back(right+1);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
};


