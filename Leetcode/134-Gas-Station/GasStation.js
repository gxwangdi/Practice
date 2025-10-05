/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
    if (!gas || !cost || gas.length != cost.length) {
        return -1
    }
    var sum=0
    var total=0
    var last=-1
    for (var i=0; i<gas.length; i++) {
        sum += gas[i]-cost[i]
        total += gas[i]-cost[i]
        if (sum<0) {
            last=i
            sum=0
        }
    }
    if (total<0) {
        return -1
    }
    return last+1
};
