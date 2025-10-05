class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        if (digits.size() == 0) {
            return digits;
        }
        if (digits[digits.size()-1]<9) {
            digits[digits.size()-1]++;
            return digits;
        }
        int i = digits.size()-1;
        while (i>=0) {
            if (digits[i]==9) {
                digits[i] = 0;
                i--;
            } else {
                digits[i]++;
                break;
            }
        }
        if (i==-1) {
            digits.insert(digits.begin(), 1);
        }
        return digits;
    }
};
