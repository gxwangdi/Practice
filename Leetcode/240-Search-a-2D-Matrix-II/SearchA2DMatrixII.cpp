class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0 || matrix[0].size() == 0) {
            return false;
        }
        int i =0;
        int j = matrix[0].size()-1;
        while(i < matrix.size() && j>=0) {
            int temp = matrix[i][j];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
};
