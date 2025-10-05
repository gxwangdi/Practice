class Solution {
public:
    int trap(vector<int>& height) {
        int total=0;
        if (height.size()<3) {
            return total;
        }
        int len = height.size();
        int left[len];
        int right[len];

        int max = height[0];
        for(int i=1; i<len; i++) {
            left[i] = std::max(max, height[i-1]);
            max = std::max(max, height[i]);
        }

        max = height[len-1];
        for (int i=len-2; i>=0; i--) {
            right[i] = std::max(max, height[i+1]);
            max = std::max(max, height[i]);
        }

        int sum;
        for (int i=1; i<len-1; i++) {
            sum = std::min(left[i], right[i]) - height[i];
            if (sum>0) {
                total += sum;
            }
        }
        return total;
    }
};
