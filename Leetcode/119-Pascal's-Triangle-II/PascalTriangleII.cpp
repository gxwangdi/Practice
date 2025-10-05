class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> cur;
        if (rowIndex<0) {
            return cur;
        }
        cur.push_back(1);
        if (rowIndex == 0) {
            return cur;
        }
        cur.push_back(1);
        if (rowIndex == 1) {
            return cur;
        }
        vector<int> next;
        for (int k=2; k<=rowIndex; k++) {
            for (int i=0; i<=k; i++) {
                if (i == 0 || i == k) {
                    next.push_back(1);
                    continue;
                }
                next.push_back(cur.at(i-1) + cur.at(i));
            }
            cur = next;
            next.clear();
        }
        return cur;
    }
};
