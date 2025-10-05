class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        if (s.length() == 0) {
            return res;
        }
        bool flag[256] = {false}; // Assuming ASCII
        int start = 0;
        int len = s.length();
        for (int i=0; i<len; i++) {
            char cur = s.at(i);
            if (!flag[cur]) {
                flag[cur] = true;
                continue;
            }
            res = max(res, i-start);
            for (int j=start; j<i; j++) {
                char c = s.at(j);
                if (c == cur) {
                    start = j+1;
                    break;
                }
                flag[c] = false;
            }
        }
        res = max(res, len - start);
        return res;
    }
};

