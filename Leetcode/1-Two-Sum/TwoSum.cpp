class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        if (nums.size() < 2) {
            return res;
        }
        map<int, int> hashMap;
        hashMap.clear();
        for (int i = 0; i < nums.size(); i++) {
            int key = target - nums[i];
            if (hashMap.find(key) != hashMap.end()) {
                res.push_back(hashMap[key]);
                res.push_back(i);
                return res;
            }
            hashMap[nums[i]] = i;
        }
        return res;
    }
};

