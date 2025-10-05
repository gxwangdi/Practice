class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (nums.empty()) {
            return 0;
        }
        int len = 0;
        for (auto i=nums.begin(), j = nums.begin(); j!= nums.end(); j++) {
            if (*j!=val) {
                *i = *j;
                i++;
                len++;
            }
        }
        return len;
    }
};


