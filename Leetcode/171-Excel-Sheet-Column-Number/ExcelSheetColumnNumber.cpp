class Solution {
public:
    int titleToNumber(string s) {
        int len = s.length();
        if (len < 1) {
            return 0;
        }
        int total = 0;
        
        for (int i=0; i<len; i++) {
            total *= 26;
            total += s.at(i)-'A'+1;
        }
        return total;
    }
};
