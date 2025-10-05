class Solution {
public:
    bool isPalindrome(string s) {
        if (s.size() <2) {
            return true;
        }
        int left=0;
        int right=s.size()-1;
        while (left < right) {
            if (isalnum(s[left])==false) {
                left++;
                continue;
            }
            if (isalnum(s[right])==false) {
                right--;
                continue;
            }
            if (tolower(s[left]) != tolower(s[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
};

