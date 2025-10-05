class Solution {
public:
    bool validPalindrome(string s) {
        return valid(s, 0, s.size()-1, 0);
    }
private:
    bool valid(string s, int left, int right, int times) {
        while (left < right) {
            if (s.at(left) != s.at(right)) {
                if (times<1) {
                    return valid(s, left+1, right, times+1) || valid(s, left, right-1, times+1);
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
};


