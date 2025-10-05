class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int res=0;
        int count=0;
        for (int num : nums) {
            if (count==0) {
                res = num;
                count++;
            } else {
                (num == res)?count++:count--;
            }
        }
        return res;
    }
};


