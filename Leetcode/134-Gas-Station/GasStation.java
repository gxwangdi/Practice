public class GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        
        int sum = 0;
        int total = 0;
        int last = -1;
        for (int i=0; i<gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                last = i;
                sum = 0;
            }
        }
        if (total < 0) {
            return -1;
        }
        return last +1;
    }
    
    /*
    // brute force,  TLE
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        
        for (int i=0; i<gas.length; i++) {
            if (gas[i] - cost[i] < 0) {
                continue;
            }
            int sum = gas[i] - cost[i];
            int cur = i+1;
            while (cur%gas.length!=i && sum>=0) {
                sum += gas[cur%gas.length] - cost[cur%gas.length];
                cur++;
            }
            if (cur%gas.length == i && sum>=0) {
                return i;
            }
        }
        return -1;
    }
    */
}




