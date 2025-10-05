class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) {
            return "";
        }
        if (strs.size() == 1) {
            return strs[0];
        }
        for (int i=0; i<strs[0].length(); i++) {
            char c = strs[0].at(i);
            for (int j=1; j<strs.size(); j++) {
                if (i<strs[j].length() && c==strs[j].at(i)) {
                    continue;
                }
                return strs[0].substr(0,i);
            }
        }
        // strs[0] could be the shortest.
        return strs[0];
    }
};
