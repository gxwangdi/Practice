/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    var upper = Math.pow(2, 31)-1
    var m = Math.abs(x)
    if (m > upper) {
        return 0
    }
    var total = 0
    var mod
    while (m>0) {
        mod = m%10
        total = total*10 + mod
        m = Math.floor(m/10)
    }
    if (total > upper) {
        return 0
    }
    if (x < 0) {
        total *= -1
    }
    return total
};
