class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int maxTemp = nums[0];
        int minTemp = nums[0];

        for (int i=1; i<nums.size(); i++) {
            int a = maxTemp*nums[i];
            int b = minTemp*nums[i];
            maxTemp = max(max(a,b), nums[i]);
            minTemp = min(min(a,b), nums[i]);
            maxProduct = max(maxProduct, maxTemp);
        }
        return maxProduct;
    }
};
