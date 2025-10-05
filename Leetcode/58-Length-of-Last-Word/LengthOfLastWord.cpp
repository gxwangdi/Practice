class Solution {
public:
    int lengthOfLastWord(string s) {
        int res = 0;
        int an = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.at(i) == ' ') {
                if (res != 0) {
                    an = res;
                }
                res = 0;
            } else {
                res++;
            }
        }
        if (res!=0) {
            return res;
        }
        return an;
    }
};
