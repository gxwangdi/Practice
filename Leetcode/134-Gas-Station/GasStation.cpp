class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        if (gas.size() != cost.size()) {
            return -1;
        }
        int sum=0;
        int total=0;
        int last=-1;
        for (int i=0; i<gas.size(); i++) {
            sum += gas[i]-cost[i];
            total += gas[i]-cost[i];
            if (sum<0) {
                last = i;
                sum = 0;
            }
        }
        if (total<0) {
            return -1;
        }
        return last+1;
    }
};
