/**
 * @param {number} n
 * @return {boolean}
 */
var canWinNim = function(n) {
    if (n<0) {
        return false
    }
    return n%4!=0
};
