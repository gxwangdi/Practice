class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        vector<vector<string>> res;

        for (int i=0; i<strs.size(); i++) {
            string key = strs[i];
            sort(key.begin(), key.end());
            map[key].push_back(strs[i]);
        }
        for (auto entry : map) {
            res.push_back(entry.second);
        }
        return res;
    }
};
