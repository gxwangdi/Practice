/**
 * @param {number} n
 * @return {number}
 */
var bulbSwitch = function(n) {
    if (n<1) {
        return 0
    }
    var res = 1
    while (res*res <=n) {
        res +=1
    }
    return res-1
};
