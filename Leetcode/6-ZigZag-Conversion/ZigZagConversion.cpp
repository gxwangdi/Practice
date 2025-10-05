class Solution {
public:
    string convert(string s, int numRows) {
        if (s.length() <= numRows || numRows < 2) {
            return s;
        }

        string sb;
        int size = 2*numRows-2;
        for (int i=0; i<numRows; i++) {
            for (int j=i; j<s.length(); j+=size) {
                sb += s.at(j);
                if (i!=0 && i!=numRows-1) {
                    // first one and last one has only one presense in one cycle.
                    int temp = j+size-2*i;
                    if (temp < s.length()) {
                        sb += s.at(temp);
                    }
                }
            }
        }
        return sb;
    }
};
