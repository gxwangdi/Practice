class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> res;
        int number1=0;
        int number2=0;
        int count1=0;
        int count2=0;
        int n = nums.size();
        for (int num:nums) {
            if (num==number1) {
                count1++;
            } else if (num==number2) {
                count2++;
            } else if (count1==0) {
                number1 = num;
                count1 = 1;
            } else if (count2==0) {
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num:nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            }
        }
        if (count1 > n/3) {
            res.push_back(number1);
        }
        if (count2 > n/3) {
            res.push_back(number2);
        }
        return res;
    }
};


