class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        if (nums.size() <1) {
            return i;
        }
        int j = i+1;
        int cur = nums.at(i);
        int size = nums.size();
        while (j<size) {
            if (nums.at(j) != cur) {
                i++;
                nums.at(i) = nums.at(j);
                cur = nums.at(i);
            }
            j++;
        }
        return i+1;
    }
};

