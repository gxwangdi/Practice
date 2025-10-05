class Solution {
public:
    char findTheDifference(string s, string t) {
        char cur = t.at(0);
        for (int i=1; i<t.length(); i++) {
            cur = (char)(cur^t.at(i));
        }
        for (int i=0; i<s.length(); i++) {
            cur = (char)(cur^s.at(i));
        }
        return cur;
    }
};
