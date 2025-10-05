class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        if gas is None or cost is None or len(gas)!=len(cost):
            return -1

        sum=0
        total=0
        last=-1
        for i in range(len(gas)):
            sum += gas[i]-cost[i]
            total += gas[i]-cost[i]
            if sum<0:
                last = i
                sum = 0
        if total<0:
            return -1
        return last+1
