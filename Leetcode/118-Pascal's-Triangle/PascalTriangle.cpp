class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        if (numRows<1) {
            return res;
        }
        for (int row=1; row<=numRows; row++) {
            vector<int> v;
            for (int j=0; j<row; j++) {
                if (j==0 || j==row-1) {
                    v.push_back(1);
                    continue;
                }
                if (row>2) {
                    v.push_back(res.at(row-2).at(j-1) + res.at(row-2).at(j));
                }
            }
            res.push_back(v);
        }
        return res;
    }
};
