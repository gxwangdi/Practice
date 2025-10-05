
class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int max = maxZeroDistance(seats);
        if (max % 2 == 1) {
            return max/2 + 1;
        }
        return max/2;
    }
private:
    int maxZeroDistance(vector<int>& seats) {
        bool isBeginning = true;
        int max = 0;
        int count = 0;
        for(int i=0; i<seats.size(); i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                if (isBeginning) {
                    max = std::max(max, count*2);
                } else {
                    max = std::max(max, count);
                }
                isBeginning = false;
                count = 0;
            }
        }
        if (count != 0) {
            max = std::max(max, count*2);
        }
        return max;
    }
};
