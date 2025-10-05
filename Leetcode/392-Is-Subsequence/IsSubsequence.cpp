class Solution {
public:
    bool isSubsequence(string s, string t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i=0;
        int j=0;
        while (i<s.length() && j<t.length()) {
            if (s.at(i) == t.at(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
};
