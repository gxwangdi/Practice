class Solution {
public:
    int singleNumber(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }
        int res = 0;
        for(auto i=nums.begin();i<nums.end();i++) {
            res = res^*i;
        }
        return res;
    }
};


